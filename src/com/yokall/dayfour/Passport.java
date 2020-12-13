package com.yokall.dayfour;

public class Passport {

    private String byr;
    private String iyr;
    private String eyr;
    private String hgt;
    private String hcl;
    private String ecl;
    private String pid;
    private String cid;

    public boolean isValid(boolean partTwo) {
        if (byr != null && iyr != null && eyr != null && hgt != null
                && hcl != null && ecl != null && pid != null) {

            if (partTwo) {
                try {
                    if (Validator.stringIsValidIntRange(byr, 1920, 2002)
                            && Validator.stringIsValidIntRange(iyr, 2010, 2020)
                            && Validator.stringIsValidIntRange(eyr, 2020, 2030)
                            && Validator.heightIsValid(hgt)
                            && Validator.colourIsValid(hcl)
                            && Validator.eyeColourIsValid(ecl)
                            && Validator.passportIDIsValid(pid)
                    )
                        return true;
                } catch (Exception e) {
                    return false;
                }
            }
            else {
                return true;
            }
        }

        return false;
    }

    private boolean notAValidIntRange(String field, int lowerBound, int upperBound) {
        int tempInt = Integer.parseInt(field);

        if (tempInt < lowerBound || tempInt > upperBound) {
            return true;
        }
        return false;
    }

    public String getByr() {
        return byr;
    }

    public void setByr(String byr) {
        this.byr = byr;
    }

    public String getIyr() {
        return iyr;
    }

    public void setIyr(String iyr) {
        this.iyr = iyr;
    }

    public String getEyr() {
        return eyr;
    }

    public void setEyr(String eyr) {
        this.eyr = eyr;
    }

    public String getHgt() {
        return hgt;
    }

    public void setHgt(String hgt) {
        this.hgt = hgt;
    }

    public String getHcl() {
        return hcl;
    }

    public void setHcl(String hcl) {
        this.hcl = hcl;
    }

    public String getEcl() {
        return ecl;
    }

    public void setEcl(String ecl) {
        this.ecl = ecl;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }
}
