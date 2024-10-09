package cleancode.studycafe.tobe.service;

import cleancode.studycafe.tobe.handler.PassHandler;
import cleancode.studycafe.tobe.handler.InputHandler;
import cleancode.studycafe.tobe.handler.OutputHandler;
import cleancode.studycafe.tobe.model.StudyCafeLockerPass;
import cleancode.studycafe.tobe.model.StudyCafePass;
import cleancode.studycafe.tobe.model.StudyCafePassType;
import java.util.List;
import java.util.Optional;

/**
 * 패스 필터링, 락커 처리 도메인 로직 분리
 */
public class PassService {

    private final PassHandler passHandler;

    public PassService(PassHandler passHandler) {
        this.passHandler = passHandler;
    }

    public List<StudyCafePass> getFilteredPassesByType(StudyCafePassType passType) {
        List<StudyCafePass> studyCafePasses = passHandler.getStudyCafePasses();
        return studyCafePasses.stream()
            .filter(pass -> pass.getPassType() == passType)
            .toList();
    }

    public Optional<StudyCafeLockerPass> handleLockerPassIsFixed(StudyCafePass selectedPass, OutputHandler outputHandler, InputHandler inputHandler) {
        if (selectedPass.getPassType() != StudyCafePassType.FIXED) {
            return Optional.empty();
        }

        List<StudyCafeLockerPass> lockerPasses = passHandler.getLockerPasses();
        StudyCafeLockerPass lockerPass = lockerPasses.stream()
            .filter(option -> option.getPassType() == selectedPass.getPassType() && option.getDuration() == selectedPass.getDuration())
            .findFirst()
            .orElse(null);

        if (lockerPass == null) {
            return Optional.empty();
        }

        outputHandler.askLockerPass(lockerPass);
        boolean lockerSelection = inputHandler.getLockerSelection();

        return lockerSelection ? Optional.of(lockerPass) : Optional.empty();
    }

}
