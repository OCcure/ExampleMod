package me.occure.example.mod.charge;

public abstract class ChargeController {

    protected boolean isCharging = false;
    protected boolean onScreenGauge = false;
    protected int chargeTime = 0;
    protected int maxChargeTime = 0;

    protected ChargeController() {
        this.maxChargeTime = getMaxChargeTime();
    }
    public void startCharging(){
        isCharging = true;
        chargeTime = 0;
        onStartCharging();
    }
    public void updateCharging(){
        if(isCharging) {
            chargeTime++;
            if(chargeTime > maxChargeTime){
                chargeTime = maxChargeTime;
            }
            onUpdateCharging();
        }
    }
    public void stopCharging(){
        isCharging = false;
        onScreenGauge = false;
        onStopCharging();
    }
    public boolean setOnScreenGauge(boolean ScreenGauge){
        onScreenGauge = ScreenGauge;
        return onScreenGauge;
    }
    public boolean isCharging() {
        return isCharging;
    }
    public int getChargeTime() {
        return chargeTime;
    }
    public int getMaxChargeTime(){
        return maxChargeTime;
    }
    public boolean getOnScreenGauge(){
        return onScreenGauge;
    }
    protected abstract void onStartCharging();
    protected abstract void onUpdateCharging();
    protected abstract void onStopCharging();
}
