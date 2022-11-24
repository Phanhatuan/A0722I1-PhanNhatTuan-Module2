package caseStudy.services.Const;

import java.util.regex.Pattern;

public interface FacilityConst {
    Pattern validVillaId = Pattern.compile("^SVVL-[0-9]{4}");
    Pattern validHouseId = Pattern.compile("^SVHO-[0-9]{4}");
    Pattern validRoomId = Pattern.compile("^SVRO-[0-9]{4}");
    Pattern validServiceName = Pattern.compile("^[A-Z][a-z]{3,19}$");


}
