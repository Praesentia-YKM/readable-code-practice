package cleancode.studycafe.tobe.handler;

import cleancode.studycafe.tobe.model.StudyCafeLockerPass;
import cleancode.studycafe.tobe.model.StudyCafePass;

import java.util.List;

/**
 * 다른 패스가 생기더라도 확장할 수 있도록 전략패턴 적용
 */
public interface PassHandler {
    List<StudyCafePass> getStudyCafePasses();
    List<StudyCafeLockerPass> getLockerPasses();
}

