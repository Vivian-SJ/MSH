package vo;

import util.DateUtil;
import util.PromotionType;

/**
 * Created by vivian on 16/10/22.
 */
public class Promotion_RoomQuantityVO {

    /**
     * 策略编号
     */
    public String promotionID;

    /**
     * 策略类型
     */
    public PromotionType promotionType;

    /**
     * 策略执行开始日期
     */
    public DateUtil startDate;

    /**
     * 策略执行结束日期
     */
    public DateUtil endDate;

    /**
     * 策略折扣
     */
    public double promotionDiscount;

    /**
     * 执行策略所需的最低房间数量
     */
    public int roomQuantity;


    /**
     *房间数量折扣促销策略，包括策略ID，策略类型，优惠起始时间，优惠结束时间，策略折扣，执行策略时所需的最小房间数量
     * @param promotionID
     * @param promotionType
     * @param startDate
     * @param endDate
     * @param promotionDiscount
     * @param roomQuantity
     */
    public Promotion_RoomQuantityVO(String promotionID, PromotionType promotionType, DateUtil startDate, DateUtil endDate, double promotionDiscount, int roomQuantity) {
        this.promotionID = promotionID;
        this.promotionType = promotionType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.promotionDiscount = promotionDiscount;
        this.roomQuantity = roomQuantity;
    }


}
