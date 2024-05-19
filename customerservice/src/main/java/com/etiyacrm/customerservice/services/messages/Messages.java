package com.etiyacrm.customerservice.services.messages;

public class Messages {

    public static class BusinessErrors {
        //City
        public static final String CityNameExists = "cityNameExists";
        public static final String CityIdNotAvailable = "cityIdNotAvailable";
        public static final String CityHasBeenDeleted = "cityHasBeenDeleted";

        //Individual Customer
        public static final String NationalityIdentityExists = "nationalityIdentityExists";
        public static final String IndividualCustomerIdNotAvailable = "individualCustomerIdNotAvailable";
        public static final String IndividualCustomerHasBeenDeleted = "individualCustomerHasBeenDeleted";

        public static final String IdentityNumberNotExists = "identityNumberNotExists";

        //Contact Medium
        public static final String ContactMediumIdNotAvailable = "contactMediumIdNotAvailable";

    }
}
