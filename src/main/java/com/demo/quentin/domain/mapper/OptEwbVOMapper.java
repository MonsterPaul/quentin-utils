package com.demo.quentin.domain.mapper;

import com.demo.quentin.domain.OptEwbVO;
import org.apache.ibatis.annotations.Insert;

public interface OptEwbVOMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table HS_OPT_EWB
     *
     * @mbggenerated
     */
    @Insert({
        "insert into HS_OPT_EWB (EWB_NO, OPERATION_ID, ",
        "EWB_DATE, SEND_CUSTOMER_ID, ",
        "SEND_CUSTOMER_ADDRESS_ID, RECEIVE_CUSTOMER_ID, ",
        "RECEIVE_CUSTOMER_ADDRESS_ID, PIECE, ",
        "WEIGHT, CALC_WEIGHT, ",
        "LENGTH, WIDTH, HIGH, ",
        "VOL, VOL_WEIGHT, ",
        "GOODS_TYPE_ID, GOODS_EXPLAIN, ",
        "PAY_SIDE_ID, PAY_MODE_ID, ",
        "CLASS_ID, PICK_GOODS_MODE_ID, ",
        "SMS_MODE_ID, FREIGHT_CURRENCY_ID, ",
        "INSURED_AMOUNT, INSURED_CURRENCY_ID, ",
        "COD_CHARGE, COD_CURRENCY_ID, ",
        "COD_PAY_MODE_ID, REWB_NO, ",
        "INPUT_SITE_ID, SEND_SITE_ID, ",
        "SALE_EMPLOYEE_ID, RECEIVE_EMPLOYEE_ID, ",
        "DISPATCH_SITE_ID, DISPATCH_EMPLOYEE_ID, ",
        "EC_ID, EC_WAREHOUSE_ID, ",
        "ORDER_NO, BL_SIGN, ",
        "REFUND_FLAG, WITHDRAW_FLAG, ",
        "COD_FLAG_3, COD_FLAG_4, ",
        "COD_FLAG_5, COD_FLAG_6, ",
        "REMARK, REMARK_CLOB_ID, ",
        "CREATED_BY, CREATED_TIME, ",
        "MODIFIED_BY, MODIFIED_TIME, ",
        "RD_STATUS, FIRST_FREIGHT_CHARGE, ",
        "CHECK_STATUS, PICKUP_CHARGE, ",
        "FUEL_ADD_CHARGE, EC_IN_CHARGE, ",
        "KFSLF_CHARGE, KFBXF_CHARGE, ",
        "COUPON, COUPON_RET_CHARGE, ",
        "SERVICE_DIP_FLAG, SERVICE_FIX_FLAG, ",
        "REWARD_CHARGE, DELIVERY_DEMAND, ",
        "DATA_SOURCE, MAIN_HEWB_NO, ",
        "MAIN_HEWB_NO_1, SHIPPING_METHOD, ",
        "GOODS_CATEGORY, CAN_GIVE_OUT, ",
        "ISJZ, RETURN_FLAG, OLD_EWB_NO, ",
        "IMG_DATE, RETURN_DATE, CAN_GIVE_OUTS, ",
        "MATCH_TYPE, CUSTR_QUOTE_FEE, ",
        "FREIGHT_CHARGE, FILL_STOREHOUSE, ",
        "MAPPING_VERSION, MAX_EDGE_LENGTH, ",
        "STAIRS_TYPE_ID, CARGO_TYPE_ID, ",
        "SPECIAL_PIECE, UPSTAIRS_NEW_CHARGE)",
        "values (#{ewbNo,jdbcType=VARCHAR}, #{operationId,jdbcType=DECIMAL}, ",
        "#{ewbDate,jdbcType=DATE}, #{sendCustomerId,jdbcType=DECIMAL}, ",
        "#{sendCustomerAddressId,jdbcType=DECIMAL}, #{receiveCustomerId,jdbcType=DECIMAL}, ",
        "#{receiveCustomerAddressId,jdbcType=DECIMAL}, #{piece,jdbcType=DECIMAL}, ",
        "#{weight,jdbcType=DECIMAL}, #{calcWeight,jdbcType=DECIMAL}, ",
        "#{length,jdbcType=DECIMAL}, #{width,jdbcType=DECIMAL}, #{high,jdbcType=DECIMAL}, ",
        "#{vol,jdbcType=DECIMAL}, #{volWeight,jdbcType=DECIMAL}, ",
        "#{goodsTypeId,jdbcType=DECIMAL}, #{goodsExplain,jdbcType=VARCHAR}, ",
        "#{paySideId,jdbcType=DECIMAL}, #{payModeId,jdbcType=DECIMAL}, ",
        "#{classId,jdbcType=DECIMAL}, #{pickGoodsModeId,jdbcType=DECIMAL}, ",
        "#{smsModeId,jdbcType=DECIMAL}, #{freightCurrencyId,jdbcType=DECIMAL}, ",
        "#{insuredAmount,jdbcType=DECIMAL}, #{insuredCurrencyId,jdbcType=DECIMAL}, ",
        "#{codCharge,jdbcType=DECIMAL}, #{codCurrencyId,jdbcType=DECIMAL}, ",
        "#{codPayModeId,jdbcType=DECIMAL}, #{rewbNo,jdbcType=VARCHAR}, ",
        "#{inputSiteId,jdbcType=DECIMAL}, #{sendSiteId,jdbcType=DECIMAL}, ",
        "#{saleEmployeeId,jdbcType=DECIMAL}, #{receiveEmployeeId,jdbcType=DECIMAL}, ",
        "#{dispatchSiteId,jdbcType=DECIMAL}, #{dispatchEmployeeId,jdbcType=DECIMAL}, ",
        "#{ecId,jdbcType=DECIMAL}, #{ecWarehouseId,jdbcType=DECIMAL}, ",
        "#{orderNo,jdbcType=VARCHAR}, #{blSign,jdbcType=DECIMAL}, ",
        "#{refundFlag,jdbcType=DECIMAL}, #{withdrawFlag,jdbcType=DECIMAL}, ",
        "#{codFlag3,jdbcType=DECIMAL}, #{codFlag4,jdbcType=DECIMAL}, ",
        "#{codFlag5,jdbcType=DECIMAL}, #{codFlag6,jdbcType=DECIMAL}, ",
        "#{remark,jdbcType=VARCHAR}, #{remarkClobId,jdbcType=DECIMAL}, ",
        "#{createdBy,jdbcType=DECIMAL}, #{createdTime,jdbcType=DATE}, ",
        "#{modifiedBy,jdbcType=DECIMAL}, #{modifiedTime,jdbcType=DATE}, ",
        "#{rdStatus,jdbcType=DECIMAL}, #{firstFreightCharge,jdbcType=DECIMAL}, ",
        "#{checkStatus,jdbcType=DECIMAL}, #{pickupCharge,jdbcType=DECIMAL}, ",
        "#{fuelAddCharge,jdbcType=DECIMAL}, #{ecInCharge,jdbcType=DECIMAL}, ",
        "#{kfslfCharge,jdbcType=DECIMAL}, #{kfbxfCharge,jdbcType=DECIMAL}, ",
        "#{coupon,jdbcType=VARCHAR}, #{couponRetCharge,jdbcType=DECIMAL}, ",
        "#{serviceDipFlag,jdbcType=DECIMAL}, #{serviceFixFlag,jdbcType=DECIMAL}, ",
        "#{rewardCharge,jdbcType=DECIMAL}, #{deliveryDemand,jdbcType=VARCHAR}, ",
        "#{dataSource,jdbcType=DECIMAL}, #{mainHewbNo,jdbcType=VARCHAR}, ",
        "#{mainHewbNo1,jdbcType=VARCHAR}, #{shippingMethod,jdbcType=DECIMAL}, ",
        "#{goodsCategory,jdbcType=DECIMAL}, #{canGiveOut,jdbcType=VARCHAR}, ",
        "#{isjz,jdbcType=CHAR}, #{returnFlag,jdbcType=DECIMAL}, #{oldEwbNo,jdbcType=VARCHAR}, ",
        "#{imgDate,jdbcType=DATE}, #{returnDate,jdbcType=DATE}, #{canGiveOuts,jdbcType=VARCHAR}, ",
        "#{matchType,jdbcType=DECIMAL}, #{custrQuoteFee,jdbcType=DECIMAL}, ",
        "#{freightCharge,jdbcType=DECIMAL}, #{fillStorehouse,jdbcType=DECIMAL}, ",
        "#{mappingVersion,jdbcType=DECIMAL}, #{maxEdgeLength,jdbcType=DECIMAL}, ",
        "#{stairsTypeId,jdbcType=DECIMAL}, #{cargoTypeId,jdbcType=DECIMAL}, ",
        "#{specialPiece,jdbcType=DECIMAL}, #{upstairsNewCharge,jdbcType=DECIMAL})"
    })
    int insert(OptEwbVO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table HS_OPT_EWB
     *
     * @mbggenerated
     */
    int insertSelective(OptEwbVO record);

    /**
     * 根据运单号查询运单信息
     * @Author: guoqun.yang
     * @Date:   2017/12/27 10:43
     * @param   ewbNo
     * @version 1.0
     */
    OptEwbVO selectByEwbNo(String ewbNo);
}