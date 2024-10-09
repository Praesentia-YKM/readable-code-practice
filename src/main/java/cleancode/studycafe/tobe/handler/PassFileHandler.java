package cleancode.studycafe.tobe.handler;

import cleancode.studycafe.tobe.model.StudyCafeLockerPass;
import cleancode.studycafe.tobe.model.StudyCafePass;

import java.util.List;

/**
 * 파일로부터 패스 데이터를 읽어오는 책임
 */
public class PassFileHandler implements PassHandler {

    private final StudyCafeFileHandler fileHandler;

    public PassFileHandler(StudyCafeFileHandler fileHandler) {
        this.fileHandler = fileHandler;
    }

    @Override
    public List<StudyCafePass> getStudyCafePasses() {
        return fileHandler.readStudyCafePasses();
    }

    @Override
    public List<StudyCafeLockerPass> getLockerPasses() {
        return fileHandler.readLockerPasses();
    }
}

