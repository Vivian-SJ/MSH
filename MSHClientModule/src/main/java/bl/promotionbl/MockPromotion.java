package bl.promotionbl;

import util.DateUtil;
import util.PromotionType;
import util.ResultMessage;
import vo.PromotionVO;

import java.util.ArrayList;

/**
 * Created by vivian on 16/11/2.
 */
public class MockPromotion extends Promotion{
    private PromotionVO pvo = new PromotionVO("201610120102", PromotionType.Hotel_Birthday, new DateUtil(2016,10,01), new DateUtil(2016,10,03), 0.80, "00000000", null, null, 0, 0);

    /**
     * 增加一个促销策略
     * @param promotionVO
     * @return 添加成功与否
     */
    public ResultMessage add(PromotionVO promotionVO){
        return ResultMessage.SUCCESS;
    }

    /**
     * 删除一个促销策略
     * @param promotionID
     * @return 删除成功与否
     */
    public ResultMessage delete(String promotionID){
        if(promotionID.equals("201610120102")){
            return ResultMessage.SUCCESS;
        }else{
            return ResultMessage.FAILED;
        }
    }

    /**
     * 更新一个促销策略
     * @param promotionID
     * @param promotionVO
     * @return 更新成功与否
     */
    public ResultMessage update(String promotionID , PromotionVO promotionVO){
        if(promotionID.equals("201610120102")){
            return ResultMessage.SUCCESS;
        }else{
            return ResultMessage.FAILED;
        }
    }

    /**
     * 精确查找某个策略
     * @param promotionID
     * @return 符合条件的策略VO
     */
    public PromotionVO searchByID(String promotionID) {
        if (promotionID.equals("201610120102")) {
            return pvo;
        }else{
            System.out.println("There is not avaliable promotion");
            return null;
        }
    }

    /**
     * 搜索某一类型的所有策略
     * @param promotionType
     * @return 符合条件的策略VO的列表
     */
    public ArrayList<PromotionVO> search(PromotionType promotionType){
        ArrayList<PromotionVO> pvos = new ArrayList<PromotionVO>();
        pvos.add(pvo);
        if(promotionType== PromotionType.Hotel_Birthday){
            return pvos;
        }else{
            System.out.println("There are not avaliable promotions");
            return null;
        }
    }

    /**
     * 搜索某个酒店的所有促销策略
     * @param HotelID
     * @return 符合条件的策略VO的列表
     */
    public ArrayList<PromotionVO> searchHotelPromotions(String HotelID){
        ArrayList<PromotionVO> pvos = new ArrayList<PromotionVO>();
        pvos.add(pvo);
        if(HotelID.equals("00000000")){
            return pvos;
        }else{
            System.out.println("There are not avaliable promotions");
            return null;
        }
    }

    /**
     * 搜索所有的网站促销策略
     * @return 符合条件的策略VO的列表
     */
    public ArrayList<PromotionVO> searchWebPromotions(){
        ArrayList<PromotionVO> pvos = new ArrayList<PromotionVO>();
        PromotionVO promotionVO = new PromotionVO("201610120103", PromotionType.Web_SpecilaDate, new DateUtil(2016,10,01), new DateUtil(2016,10,03), 0.80, null, null, null, 0, 0);
        pvos.add(promotionVO);
            return pvos;
    }

}
