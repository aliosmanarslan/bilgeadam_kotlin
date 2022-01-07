package _2_xmlparser;

public class TCMB {

    private String currencyName;
    private String forexBuying;
    private String forexSelling;
    private String banknoteBuying;
    private String banknoteSelling;

    public TCMB(String currencyName, String forexBuying, String forexSelling, String banknoteBuying, String banknoteSelling) {
        this.currencyName = currencyName;
        this.forexBuying = forexBuying;
        this.forexSelling = forexSelling;
        this.banknoteBuying = banknoteBuying;
        this.banknoteSelling = banknoteSelling;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public String getForexBuying() {
        return forexBuying;
    }

    public void setForexBuying(String forexBuying) {
        this.forexBuying = forexBuying;
    }

    public String getForexSelling() {
        return forexSelling;
    }

    public void setForexSelling(String forexSelling) {
        this.forexSelling = forexSelling;
    }

    public String getBanknoteBuying() {
        return banknoteBuying;
    }

    public void setBanknoteBuying(String banknoteBuying) {
        this.banknoteBuying = banknoteBuying;
    }

    public String getBanknoteSelling() {
        return banknoteSelling;
    }

    public void setBanknoteSelling(String banknoteSelling) {
        this.banknoteSelling = banknoteSelling;
    }
}
