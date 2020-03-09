package com.amdocs.migration.beans;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("plan")

public class Plans
{
    private String SELECTION_CRI;

    private String MISC_INFO;

    private String INHERIT_SEL_CRI;

    private String GLOBAL_RANK;

    private String PLAN_CONDITIONAL;

    private String INHERIT_OBJ_TYPE;

    private String DP_NUM5;

    private String DP_NUM3;

    private String DP_NUM4;

    private String WORK_OBJ_TYPE;

    private String DP_NUM1;

    private String DP_NUM2;

    private String DP_STR3;

    private String CONTINUS_DURATION;

    private String DP_STR5;

    private String DP_STR4;

    private String CONT_CALC_TYPE;

    private String NEW_DESC_HANDLING;

    private String DP_STR1;

    public String getSELECTION_CRI ()
    {
        return SELECTION_CRI;
    }

    public void setSELECTION_CRI (String SELECTION_CRI)
    {
        this.SELECTION_CRI = SELECTION_CRI;
    }

    public String getMISC_INFO ()
    {
        return MISC_INFO;
    }

    public void setMISC_INFO (String MISC_INFO)
    {
        this.MISC_INFO = MISC_INFO;
    }

    public String getINHERIT_SEL_CRI ()
    {
        return INHERIT_SEL_CRI;
    }

    public void setINHERIT_SEL_CRI (String INHERIT_SEL_CRI)
    {
        this.INHERIT_SEL_CRI = INHERIT_SEL_CRI;
    }

    public String getGLOBAL_RANK ()
    {
        return GLOBAL_RANK;
    }

    public void setGLOBAL_RANK (String GLOBAL_RANK)
    {
        this.GLOBAL_RANK = GLOBAL_RANK;
    }

    public String getPLAN_CONDITIONAL ()
    {
        return PLAN_CONDITIONAL;
    }

    public void setPLAN_CONDITIONAL (String PLAN_CONDITIONAL)
    {
        this.PLAN_CONDITIONAL = PLAN_CONDITIONAL;
    }

    public String getINHERIT_OBJ_TYPE ()
    {
        return INHERIT_OBJ_TYPE;
    }

    public void setINHERIT_OBJ_TYPE (String INHERIT_OBJ_TYPE)
    {
        this.INHERIT_OBJ_TYPE = INHERIT_OBJ_TYPE;
    }

    public String getDP_NUM5 ()
    {
        return DP_NUM5;
    }

    public void setDP_NUM5 (String DP_NUM5)
    {
        this.DP_NUM5 = DP_NUM5;
    }

    public String getDP_NUM3 ()
    {
        return DP_NUM3;
    }

    public void setDP_NUM3 (String DP_NUM3)
    {
        this.DP_NUM3 = DP_NUM3;
    }

    public String getDP_NUM4 ()
    {
        return DP_NUM4;
    }

    public void setDP_NUM4 (String DP_NUM4)
    {
        this.DP_NUM4 = DP_NUM4;
    }

    public String getWORK_OBJ_TYPE ()
    {
        return WORK_OBJ_TYPE;
    }

    public void setWORK_OBJ_TYPE (String WORK_OBJ_TYPE)
    {
        this.WORK_OBJ_TYPE = WORK_OBJ_TYPE;
    }

    public String getDP_NUM1 ()
    {
        return DP_NUM1;
    }

    public void setDP_NUM1 (String DP_NUM1)
    {
        this.DP_NUM1 = DP_NUM1;
    }

    public String getDP_NUM2 ()
    {
        return DP_NUM2;
    }

    public void setDP_NUM2 (String DP_NUM2)
    {
        this.DP_NUM2 = DP_NUM2;
    }

    public String getDP_STR3 ()
    {
        return DP_STR3;
    }

    public void setDP_STR3 (String DP_STR3)
    {
        this.DP_STR3 = DP_STR3;
    }

    public String getCONTINUS_DURATION ()
    {
        return CONTINUS_DURATION;
    }

    public void setCONTINUS_DURATION (String CONTINUS_DURATION)
    {
        this.CONTINUS_DURATION = CONTINUS_DURATION;
    }

    public String getDP_STR5 ()
    {
        return DP_STR5;
    }

    public void setDP_STR5 (String DP_STR5)
    {
        this.DP_STR5 = DP_STR5;
    }

    public String getDP_STR4 ()
    {
        return DP_STR4;
    }

    public void setDP_STR4 (String DP_STR4)
    {
        this.DP_STR4 = DP_STR4;
    }

    public String getCONT_CALC_TYPE ()
    {
        return CONT_CALC_TYPE;
    }

    public void setCONT_CALC_TYPE (String CONT_CALC_TYPE)
    {
        this.CONT_CALC_TYPE = CONT_CALC_TYPE;
    }

    public String getNEW_DESC_HANDLING ()
    {
        return NEW_DESC_HANDLING;
    }

    public void setNEW_DESC_HANDLING (String NEW_DESC_HANDLING)
    {
        this.NEW_DESC_HANDLING = NEW_DESC_HANDLING;
    }

    public String getDP_STR1 ()
    {
        return DP_STR1;
    }

    public void setDP_STR1 (String DP_STR1)
    {
        this.DP_STR1 = DP_STR1;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [SELECTION_CRI = "+SELECTION_CRI+", MISC_INFO = "+MISC_INFO+", INHERIT_SEL_CRI = "+INHERIT_SEL_CRI+", GLOBAL_RANK = "+GLOBAL_RANK+", PLAN_CONDITIONAL = "+PLAN_CONDITIONAL+", INHERIT_OBJ_TYPE = "+INHERIT_OBJ_TYPE+", DP_NUM5 = "+DP_NUM5+", DP_NUM3 = "+DP_NUM3+", DP_NUM4 = "+DP_NUM4+", WORK_OBJ_TYPE = "+WORK_OBJ_TYPE+", DP_NUM1 = "+DP_NUM1+", DP_NUM2 = "+DP_NUM2+", DP_STR3 = "+DP_STR3+", CONTINUS_DURATION = "+CONTINUS_DURATION+", DP_STR5 = "+DP_STR5+", DP_STR4 = "+DP_STR4+", CONT_CALC_TYPE = "+CONT_CALC_TYPE+", NEW_DESC_HANDLING = "+NEW_DESC_HANDLING+", DP_STR1 = "+DP_STR1+"]";
    }
}