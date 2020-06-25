package odko.nanjid.onlineshop2.domain.dto;

public class ResponseDTO {
    private String message;
    private int cardSize;
    public ResponseDTO(){}

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCardSize() {
        return cardSize;
    }

    public void setCardSize(int itemCount) {
        this.cardSize = itemCount;
    }
}
