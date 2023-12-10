package org.technyx.icm.model.util;

public class RegexUtility {

    public static final String CHECK_NOT_NULL_CHAR_NUMBER_6_30 = "^(?=.*[a-zA-Z0-9])[\\w]{6,30}$";

    public static final String CHECK_NOT_NULL_CONTAIN_ENG_CHAR_AND_NUMBER_MIN_8 = "^(?!null$)(?=.*[a-zA-Z])(?=.*[0-9])[a-zA-Z0-9]{8,}$";

    public static final String CHECK_ONLY_TEN_DIGIT = "^\\d{10}$";

    public static final String CHECK_ENG_OR_PER_CHAR_2_50 = "^([a-zA-Z\\u0600-\\u06FF\\s-]{2,50})$";

    public static final String CHECK_IRI_PHONE = "^\\+98[\\s\\-]?[1-9]\\d{9}$";

    public static final String PER_POSTAL_CODE = "\\d{10}";

    public static final String PER_LOCATION = "^[\\u0600-\\u06FF0-9\\s\\-،؛؟!\\.,:]+$";
}
