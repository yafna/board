package my.painboard.service.dto;

public enum UIStatus {
    IMAGE("image"),
    HOLIDAY("holiday"),
    VACATION("vacation"),
    TOFILL("tofill"),
    EMPTY("empty");

    private String status;

    UIStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
