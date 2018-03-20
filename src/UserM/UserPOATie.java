package UserM;




public class UserPOATie extends UserPOA
{

  

  public UserPOATie ( UserM.UserOperations delegate ) {
      this._impl = delegate;
  }
  public UserPOATie ( UserM.UserOperations delegate , org.omg.PortableServer.POA poa ) {
      this._impl = delegate;
      this._poa      = poa;
  }
  public UserM.UserOperations _delegate() {
      return this._impl;
  }
  public void _delegate (UserM.UserOperations delegate ) {
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
  public void registerUser (String fullName, String telePhone)
  {
	  // Register User
	  
    _impl.registerUser(fullName, telePhone);
  } 

  public void updateInterface (String message)
  {
	  
	  // Update Interface
	  
    _impl.updateInterface(message);
    
  } 
  private UserM.UserOperations _impl;
  private org.omg.PortableServer.POA _poa;

} 
