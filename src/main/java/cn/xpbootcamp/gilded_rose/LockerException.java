package cn.xpbootcamp.gilded_rose;


class LockerException extends RuntimeException{
    private String message;

    public LockerException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
