package my.painboard.service.controller;

import java.util.ArrayList;
import java.util.List;
import my.painboard.db.model.Img;
import my.painboard.db.service.ImgService;
import my.painboard.service.dto.ActionResult;
import my.painboard.service.dto.UIImage;
import my.painboard.service.filesystem.ImgFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/imgs")
public class ImgController {
    @Autowired
    private ImgService imgService;
    @Autowired
    private ImgFileService fileStore;

    @RequestMapping("/list")
    public
    @ResponseBody
    List<UIImage> list() {
        List<UIImage> res = new ArrayList<>();
        for (Img item : imgService.list()) {
//            res.add(new UIImage(item.getUuid(), item.getDesc(), item.getLevel()));
        }
        return res;
    }

//    @RequestMapping(method = RequestMethod.POST)
//    public void save(MyObject myObject, MultipartFile file) {
//        //delegation to the correct service
//    }

    @RequestMapping("/modify")
    public
    @ResponseBody
    ActionResult addUser(@RequestBody UIImage img) {
        if(img.getUuid() == null) {
            imgService.create(null, img.getLevel(), img.getDescription());
        }else {
            imgService.update(img.getUuid(), null, img.getLevel(), img.getDescription());
        }
        return new ActionResult(true, "Seems that ok");
    }


    @RequestMapping("/remove/{uuid}")
    public
    @ResponseBody
    ActionResult removeUser(@PathVariable String uuid) {
        imgService.remove(uuid);
        return new ActionResult(true, "Seems that ok");
    }
}
