package ui.viewcontroller.staff;

import bl.blfactory.BLFactoryImpl;
import blservice.promotionblservice.PromotionBLService;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import main.Main;
import util.PromotionType;
import vo.PromotionVO;

import java.io.IOException;
import java.util.Stack;

/**
 * Created by vivian on 16/12/8.
 */
public class HotelPromotionViewController {
    private BorderPane rootPane;

    private Node initNode;
    private Stack<Node> stack = new Stack<Node>();

    private HotelPromotionListViewController hotelPromotionListViewController;

    private PromotionBLService promotionBLService;

    private PromotionVO promotionVO;

    public HotelPromotionViewController(BorderPane rootPane) {
        this.promotionBLService = new BLFactoryImpl().getPromotionBLService();
        this.rootPane = rootPane;
    }

    /**
     * 返回上一界面
     */
    public void back() {
        if (!stack.empty()) {
            Node node = stack.pop();
            rootPane.setCenter(node);

        }
    }

    /**
     * 网站促销策略列表
     */
    public void showHotelPromotionList() {
        if (initNode != null) {
            stack.clear();
            rootPane.setCenter(initNode);
            return;
        }

        try {
            FXMLLoader listLoader = new FXMLLoader();
            listLoader.setLocation(Main.class.getResource("../view/staff/HotelPromotionListView.fxml"));
            ScrollPane list = listLoader.load();

            hotelPromotionListViewController = listLoader.getController();
            hotelPromotionListViewController.setHotelPromotionViewController(this);

            initNode = list;

            rootPane.setCenter(list);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 更新策略列表
     */
    public void refreshHotelPromotionList() {
        hotelPromotionListViewController.showAllHotelPromotions();
    }

    /**
     * 展示策略详情
     *
     * @param promotionVO
     */
    public void showPromotionDetail(PromotionVO promotionVO) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("../view/staff/HotelPromotionDetailView.fxml"));
            ScrollPane view = loader.load();

            HotelPromotionDetailViewController hotelPromotionDetailViewController = loader.getController();
            hotelPromotionDetailViewController.setHotelPromotionViewController(this);
            hotelPromotionDetailViewController.setPromotionBLService(promotionBLService);
            hotelPromotionDetailViewController.showHotelPromotionDetail(promotionVO);

            Node node = rootPane.getCenter();
            stack.push(node);

            rootPane.setCenter(view);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 编辑策略
     */
//    public void showPromotionDetailEditView(PromotionVO promotionVO) {
//        this.promotionVO = promotionVO;
//        this.addWebPromotion(promotionVO.promotionType, true);
//    }

    /**
     * 增加策略
     */
    public void addHotelPromotion(PromotionType promotionType, boolean isEdit) {
        switch (promotionType) {
            case Hotel_Birthday:
                this.addHotel_BirthdayPromotion(isEdit);
                break;
            case Hotel_Enterprise:
                this.addHotel_EnterprisePromotion(isEdit);
                break;
            case Hotel_RoomQuantity:
                this.addHotel_RoomQuantityPromotion(isEdit);
                break;
            case Hotel_SpecilaDate:
                this.addHotel_SpecialDatePromotion(isEdit);
                break;
        }
    }

    /**
     * 增加或编辑酒店生日策略
     */
    public void addHotel_BirthdayPromotion(boolean isEdit) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("../view/staff/HotelPromotion_BirthdayAddView.fxml"));
            ScrollPane view = loader.load();

            HotelPromotion_BirthdayAddViewController hotelPromotion_birthdayAddViewController = loader.getController();
            hotelPromotion_birthdayAddViewController.setHotelPromotionViewController(this);
            hotelPromotion_birthdayAddViewController.setPromotionBLService(promotionBLService);
            if(isEdit){
                hotelPromotion_birthdayAddViewController.showEditView(promotionVO);
            }

            Node node = rootPane.getCenter();
            stack.push(node);

            rootPane.setCenter(view);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 增加或编辑酒店合作企业折扣策略
     */
    public void addHotel_EnterprisePromotion(boolean isEdit) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("../view/staff/HotelPromotion_EnterpriseAddView.fxml"));
            ScrollPane view = loader.load();

            HotelPromotion_EnterpriseAddViewController hotelPromotion_enterpriseAddViewController = loader.getController();
            hotelPromotion_enterpriseAddViewController.setHotelPromotionViewController(this);
            hotelPromotion_enterpriseAddViewController.setPromotionBLService(promotionBLService);
            if(isEdit){
                hotelPromotion_enterpriseAddViewController.showEditView(promotionVO);
            }

            Node node = rootPane.getCenter();
            stack.push(node);

            rootPane.setCenter(view);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 增加或编辑房间数量折扣策略
     */
    public void addHotel_RoomQuantityPromotion(boolean isEdit) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("../view/staff/HotelPromotion_RoomQuantityAddView.fxml"));
            ScrollPane view = loader.load();

            HotelPromotion_RoomQuantityAddViewController hotelPromotion_roomQuantityAddViewController = loader.getController();
            hotelPromotion_roomQuantityAddViewController.setHotelPromotionViewController(this);
            hotelPromotion_roomQuantityAddViewController.setPromotionBLService(promotionBLService);
            if(isEdit){
                hotelPromotion_roomQuantityAddViewController.showEditView(promotionVO);
            }

            Node node = rootPane.getCenter();
            stack.push(node);

            rootPane.setCenter(view);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 增加或编辑特定期间折扣策略
     */
    public void addHotel_SpecialDatePromotion(boolean isEdit) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("../view/staff/HotelPromotion_SpecialDateAddView.fxml"));
            ScrollPane view = loader.load();

            HotelPromotion_SpecialDateAddViewController hotelPromotion_specialDateAddViewController = loader.getController();
            hotelPromotion_specialDateAddViewController.setHotelPromotionViewController(this);
            hotelPromotion_specialDateAddViewController.setPromotionBLService(promotionBLService);
            if(isEdit){
                hotelPromotion_specialDateAddViewController.showEditView(promotionVO);
            }

            Node node = rootPane.getCenter();
            stack.push(node);

            rootPane.setCenter(view);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
