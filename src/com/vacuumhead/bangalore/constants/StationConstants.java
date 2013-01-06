package com.vacuumhead.bangalore.constants;

public class StationConstants {

	private static enum greenLineStationList {
		Nagasandra, Dasarahalli, Jalahalli, Peenya_Industry, Peenya, Yeshwanthpur_Industry, Yeshwanthpur, 
		Sandal_Soap_Factory, Mahalakshmi, Rajajinagar, Kuvempu_Road, Srirampura, Sampige_Road, Kempegowda, 
		Chickpete, Krishna_Rajendra_Market, National_College, Lalbagh, South_End_Circle, Jayanagar, 
		Rashtreeya_Vidyalaya_Road, Banashankari, Jaya_Prakash_Nagar, Puttenahalli
	}

	private static enum purpleLineStationList {
		Baiyappanahalli, Swami_Vivekananda_Road, Indiranagar, Halasuru, Trinity, Mahatma_Gandhi_Road, 
		Cubbon_Park, Vidhana_Soudha, Sir_M_Visveshwaraya, Kempegowda, City_Railway_Station, Magadi_Road, 
		Hosahalli, Vijayanagar, Attiguppe, Deepanjali_Nagar, Mysore_Road
	}

	public static int getStationCode(String stationName) {

		int sizeOfGreenLine = greenLineStationList.values().length;
		int sizeOfPurpleLine = purpleLineStationList.values().length;
		try {

			greenLineStationList greenCode = greenLineStationList
					.valueOf(stationName);
			if (greenCode != null) {
				return greenCode.ordinal();
			}
		} catch (Exception e) {

		}
		try {
			purpleLineStationList purpleCode = purpleLineStationList
					.valueOf(stationName);
			if (purpleCode != null) {
				return purpleCode.ordinal() + sizeOfGreenLine;
			}
		} catch (Exception e) {

		}

		return -1;
	}

	public static String getStationName(int code) {
		int sizeOfGreenLine = greenLineStationList.values().length;
		int sizeOfPurpleLine = purpleLineStationList.values().length;

		if (code < sizeOfGreenLine) {
			return greenLineStationList.values()[code].toString();
		} else if (code < sizeOfPurpleLine) {
			code = code - sizeOfGreenLine;
			return purpleLineStationList.values()[code].toString();
		}
		return null;
	}

}
