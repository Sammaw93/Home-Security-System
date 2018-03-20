package RegionalOffice;




public interface REGOFFOperations 
{
  void raiseAlarm (RegionalOffice.Alarm anAlarm, RegionalOffice.Alarm aCamera);
  void registerUser (RegionalOffice.userName user, RegionalOffice.contactDetails contact);
  void connectHOMEH (String homehName);
} 
