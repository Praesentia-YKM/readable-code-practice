package cleancode.studycafe.tobe.controller;

import cleancode.studycafe.tobe.exception.AppException;
import cleancode.studycafe.tobe.handler.InputHandler;
import cleancode.studycafe.tobe.handler.OutputHandler;
import cleancode.studycafe.tobe.model.StudyCafeLockerPass;
import cleancode.studycafe.tobe.model.StudyCafePass;
import cleancode.studycafe.tobe.model.StudyCafePassType;
import cleancode.studycafe.tobe.service.PassService;

import java.util.List;
import java.util.Optional;

/**
 * 어플리캐이션의 로직을 구분짓는 컨트롤러 역할로 분리
 */
public class StudyCafePassMachine {

    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;
    private final PassService passService;

    public StudyCafePassMachine(InputHandler inputHandler, OutputHandler outputHandler, PassService passService) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
        this.passService = passService;
    }

    public void run() {
        try {
            showInitialMessages();
            StudyCafePassType studyCafePassType = getPassTypeSelection();
            List<StudyCafePass> filteredPasses = passService.getFilteredPassesByType(studyCafePassType);

            StudyCafePass selectedPass = getSelectedPass(filteredPasses);
            Optional<StudyCafeLockerPass> lockerPassOptional = passService.handleLockerPassIsFixed(selectedPass, outputHandler, inputHandler);

            showOrderSummary(selectedPass, lockerPassOptional);

        } catch (AppException e) {
            outputHandler.showSimpleMessage(e.getMessage());
        } catch (Exception e) {
            outputHandler.showSimpleMessage("알 수 없는 오류가 발생했습니다.");
        }
    }

    private void showInitialMessages() {
        outputHandler.showWelcomeMessage();
        outputHandler.showAnnouncement();
    }

    private StudyCafePassType getPassTypeSelection() {
        outputHandler.askPassTypeSelection();
        return inputHandler.getPassTypeSelectingUserAction();
    }

    private StudyCafePass getSelectedPass(List<StudyCafePass> filteredPasses) {
        outputHandler.showPassListForSelection(filteredPasses);
        return inputHandler.getSelectPass(filteredPasses);
    }

    private void showOrderSummary(StudyCafePass selectedPass, Optional<StudyCafeLockerPass> lockerPassOptional) {
        lockerPassOptional.ifPresentOrElse(
            lockerPass -> outputHandler.showPassOrderSummary(selectedPass, lockerPass),
            () -> outputHandler.showPassOrderSummary(selectedPass, null)
        );
    }
}
