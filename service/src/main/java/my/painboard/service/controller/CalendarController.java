package my.painboard.service.controller;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import my.painboard.db.model.Img;
import my.painboard.db.model.ReportDay;
import my.painboard.db.model.ReportedAction;
import my.painboard.db.model.User;
import my.painboard.db.service.ImgService;
import my.painboard.db.service.ReportActionService;
import my.painboard.db.service.ReportDayService;
import my.painboard.db.service.TeamService;
import my.painboard.db.service.UserService;
import my.painboard.service.dto.UIImage;
import my.painboard.service.dto.UIReportDay;
import my.painboard.service.dto.UIStatus;
import my.painboard.service.dto.UIStatusDay;
import my.painboard.service.dto.UITable;
import my.painboard.service.dto.UIUser;
import my.painboard.service.dto.UIUserState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calendar")
public class CalendarController {
    @Autowired
    private ImgService imgService;
    @Autowired
    private TeamService teamService;
    @Autowired
    private UserService userService;
    @Autowired
    private ReportDayService reportDayService;
    @Autowired
    private ReportActionService reportActionService;

    private boolean done = false;

    public void doprefill() {
        String teamid = teamService.create("daas reboot");
        userService.create("N", teamid);
        userService.create("V", teamid);
        userService.create("T", teamid);
        imgService.create("0.png", 10, "happy");
        imgService.create("1.png", 5, "medium");
        imgService.create("2.png", 0, "not happy");
        reportDayService.create(LocalDate.now().getDayOfYear(),LocalDate.now().getYear());
        done = true;
    }

    public void fillDays() {
        List<ReportDay> days = reportDayService.list();
        Collections.sort(days, (o1, o2) -> o1.getYear() != o2.getYear() ? o1.getYear() - o2.getYear() : o1.getDay() - o2.getDay());
        if (days.get(days.size() - 1).getDay() < LocalDate.now().plusDays(30).getDayOfYear()) {
            for (int i = days.get(days.size() - 1).getDay() + 1; i < LocalDate.now().plusDays(30).getDayOfYear(); ++i) {
                 reportDayService.create(i,LocalDate.now().getYear());
            }
        }
    }

    @RequestMapping("/all")
    public
    @ResponseBody
    UITable list() {
        if (!done) {
            doprefill();
        }
         fillDays();
        LocalDate localDate = LocalDate.now();
        Integer day = LocalDate.now().getDayOfMonth();
        List<UIReportDay> days = new ArrayList<>();
        for (int i = 0; i <= 14; ++i) {
            ReportDay rd = reportDayService.getDay(localDate.plusDays(i).getDayOfYear(), localDate.getYear());
            LocalDate d1= LocalDate.ofYearDay(rd.getYear(), rd.getDay());
            days.add(new UIReportDay(rd.getUuid(), d1.getDayOfMonth()));
        }
        UITable table = new UITable();
        table.setDays(days);
        List<UIImage> imgs = new ArrayList<>();
        for (Img img : imgService.list()) {
            imgs.add(new UIImage(img.getUuid(), img.getDesc(), img.getLevel(), img.getPath()));
        }
        table.setImgs(imgs);
        DayOfWeek dayOfWeek = LocalDate.now().getDayOfWeek();
        List<User> users = userService.list();
        for (User user : users) {
            UIUserState uiUserState = new UIUserState();
            uiUserState.setUser(new UIUser(user.getUuid(), user.getName(), user.getTeam().getName()));
            for (int i = 0; i <= 14; ++i) {
                UIStatusDay statusDay = new UIStatusDay();
                ReportDay rd = reportDayService.getDay(localDate.plusDays(i).getDayOfYear(), localDate.getYear());
                ReportedAction action = reportActionService.getByDayAndUser(user.getUuid(), rd.getUuid());
                if(action != null){
                    statusDay.setStatus(UIStatus.IMAGE);
                    statusDay.setImage(new UIImage(action.getImg().getUuid(), action.getImg().getDesc(), action.getImg().getLevel(), action.getImg().getPath()));
                }else  if(i == 0) {
                    statusDay.setStatus(UIStatus.TOFILL);
                }else {
                    if (localDate.plusDays(i).getDayOfWeek() == DayOfWeek.SATURDAY || localDate.plusDays(i).getDayOfWeek() == DayOfWeek.SUNDAY) {
                        statusDay.setStatus(UIStatus.HOLIDAY);
                    } else {
                        statusDay.setStatus(UIStatus.EMPTY);
                    }
                }

                LocalDate d1= LocalDate.ofYearDay(rd.getYear(), rd.getDay());
                statusDay.setDay(new UIReportDay(rd.getUuid(), d1.getDayOfMonth()));
                table.getDates().add(localDate.plusDays(i).getDayOfMonth());
                uiUserState.getStatusday().add(statusDay);
            }
            table.getUiUsers().add(uiUserState);
        }
        return table;
    }

    @RequestMapping("register/{userId}/{dayId}/{imgId}")
    public void register(@PathVariable String userId, @PathVariable String dayId, @PathVariable String imgId) {
        System.out.println("userId = " + userId);
        System.out.println("dayId = " + dayId);
        System.out.println("imgId = " + imgId);
        reportActionService.create(userId, dayId, imgId);
    }
}
