package RegionalOffice;



public class REGOFFPOATie extends REGOFFPOA
{

  // Constructors

  public REGOFFPOATie ( RegionalOffice.REGOFFOperations delegate ) {
      this._impl = delegate;
  }
  public REGOFFPOATie ( RegionalOffice.REGOFFOperations delegate , org.omg.PortableServer.POA poa ) {
      this._impl = delegate;
      this._poa      = poa;
  }
  public RegionalOffice.REGOFFOperations _delegate() {
      return this._impl;
  }
  public void _delegate (RegionalOffice.REGOFFOperations delegate ) {
      this._impl = delegate;
  }
  public org.omg.PortableServer.POA _default_POA() {
      if(_poa != null) {
          return _poa;
      }
      else {
          return super._default_POA();
      }
  }
  public void raiseAlarm (RegionalOffice.Alarm anAlarm, RegionalOffice.Alarm aCamera)
  {
	  // Raise the alarm
	  
    _impl.raiseAlarm(anAlarm, aCamera);
  }

  public void registerUser (RegionalOffice.userName user, RegionalOffice.contactDetails contact)
  {
	  //Register User
	  
    _impl.registerUser(user, contact);
  } 

  public void connectHOMEH (String homehName)
  {
	// connect HomeHub

    _impl.connectHOMEH(homehName);
    
  } 

  private RegionalOffice.REGOFFOperations _impl;
  private org.omg.PortableServer.POA _poa;

} 
