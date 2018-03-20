package RegionalOffice;



public final class AlarmData implements org.omg.CORBA.portable.IDLEntity
{
  public RegionalOffice.Alarm aReading = null;
  public RegionalOffice.Alarm aConfirmingCamera = null;

  public AlarmData ()
  {
  } 

  public AlarmData (RegionalOffice.Alarm _aReading, RegionalOffice.Alarm _aConfirmingCamera)
  {
    aReading = _aReading;
    aConfirmingCamera = _aConfirmingCamera;
  } 

} 
