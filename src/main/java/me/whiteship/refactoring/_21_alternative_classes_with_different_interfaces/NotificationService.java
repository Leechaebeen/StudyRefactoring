package me.whiteship.refactoring._21_alternative_classes_with_different_interfaces;

public interface NotificationService {
    // 추상 계층을 하나 더 만들어서 기존에 있는 api 들을 감싼다.
    void sendNotification(Notification notification);
}
