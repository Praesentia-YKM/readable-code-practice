package cleancode.minesweeper.tobe;

// 우리가 의도한 예외 라는 뜻.
// 상속 구조에서는 부모 클래스 타입은 자식 클래스 타입으로 자동으로 변환되지 않습니다.
// 즉, RuntimeException의 다른 하위 클래스가 throw될 때는 그 예외는 해당 예외 타입으로만 처리할 수 있습니다.
public class AppException extends RuntimeException {

    public AppException(String message) {
        super(message);
    }

}