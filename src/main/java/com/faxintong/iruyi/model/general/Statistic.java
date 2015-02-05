package com.faxintong.iruyi.model.general;




/**
 * Created by hehj on 15-1-3.
 */
public class Statistic {
    private Long receiveOrderCount;
    private Long sendOrderCount;
    private Long receiveSuccessConut;
    private Double receiveSuccessRate;
    private Long sendSuccessCount;
    private Double sendSuccessRate;
    private Long invalidOrderCount;
    private Long recevieOrderTLECount;
    private Long sendOrderTLECount;
    private Double recevieDealAmount;
    private Double sendDealAmount;



    public Long getReceiveOrderCount() {
        return receiveOrderCount;
    }

    public Long getSendOrderCount() {
        return sendOrderCount;
    }

    public Long getReceiveSuccessConut() {
        return receiveSuccessConut;
    }

    public Long getSendSuccessCount() {
        return sendSuccessCount;
    }

    public Long getRecevieOrderTLECount() {
        return recevieOrderTLECount;
    }

    public Long getSendOrderTLECount() {
        return sendOrderTLECount;
    }

    public Double getRecevieDealAmount() {
        return recevieDealAmount;
    }

    public Double getSendDealAmount() {
        return sendDealAmount;
    }

    public Double getReceiveSuccessRate() {
        return receiveSuccessRate;
    }

    public Double getSendSuccessRate() {
        return sendSuccessRate;
    }

    public Long getInvalidOrderCount(){
        return invalidOrderCount;
    }



    public void setReceiveOrderCount(Long value) {
        receiveOrderCount=value;
    }

    public void setSendOrderCount(Long value) {
        sendOrderCount=value;
    }

    public void setReceiveSuccessConut(Long value) {
        receiveSuccessConut=value;
    }

    public void setSendSuccessCount(Long value) {
        sendSuccessCount=value;
    }

    public void setRecevieOrderTLECount(Long value) {
        recevieOrderTLECount=value;
    }

    public void setSendOrderTLECount(Long value) {
        sendOrderTLECount=value;
    }

    public void setRecevieDealAmount(Double value) {
        recevieDealAmount=value;
    }

    public void setSendDealAmount(Double value) {
        sendDealAmount=value;
    }

    public void setReceiveSuccessRate(Double value) {
        receiveSuccessRate=value;
    }

    public void setSendSuccessRate(Double value) {
        sendSuccessRate=value;
    }

    public void setInvalidOrderCount(Long value){
        invalidOrderCount=value;
    }


}
