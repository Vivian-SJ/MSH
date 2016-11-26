package ui.componentcontroller.order.manager;

import component.statebutton.StateButton;
import javafx.fxml.FXML;
import ui.viewcontroller.manager.WorkerManagementListViewController;

/**
 * Created by Kray on 2016/11/26.
 */
public class WorkerManagementListPaneController {

    private WorkerManagementListViewController workerManagementListViewController;

    @FXML
    private StateButton allButton;

    @FXML
    private StateButton staffButton;

    @FXML
    private StateButton salesmanButton;

    private StateButton[] buttons;

    public void setWorkerManagementListViewController(WorkerManagementListViewController workerManagementListViewController) {
        this.workerManagementListViewController = workerManagementListViewController;

        buttons = new StateButton[]{allButton, staffButton, salesmanButton};
    }

    @FXML
    public void showAllWorkers() {
        setButtonsInactive();
        allButton.setIsActiveProperty(true);
        workerManagementListViewController.showAllWorkers();
    }

    @FXML
    public void showStaff() {
        setButtonsInactive();
        staffButton.setIsActiveProperty(true);
        workerManagementListViewController.showStaff();
    }

    @FXML
    public void showSalesman() {
        setButtonsInactive();
        salesmanButton.setIsActiveProperty(true);
        workerManagementListViewController.showSalesman();
    }

    private void setButtonsInactive() {
        for (StateButton button : buttons) {
            button.setIsActiveProperty(false);
        }
    }
}
