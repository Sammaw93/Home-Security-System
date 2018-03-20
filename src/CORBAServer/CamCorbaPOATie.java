package CORBAServer;



public class CamCorbaPOATie extends CamCorbaPOA
{

  

  public CamCorbaPOATie ( CORBAServer.CamCorbaOperations delegate ) {
      this._impl = delegate;
  }
  public CamCorbaPOATie ( CORBAServer.CamCorbaOperations delegate , org.omg.PortableServer.POA poa ) {
      this._impl = delegate;
      this._poa      = poa;
  }
  public CORBAServer.CamCorbaOperations _delegate() {
      return this._impl;
  }
  public void _delegate (CORBAServer.CamCorbaOperations delegate ) {
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
  public String name ()
  {
    return _impl.name();
  } // name

  public boolean currentStatus ()
  {
    return _impl.currentStatus();
    
  } // Gets the current status

  public CORBAServer.Alarm getAlarm ()
  {
    return _impl.getAlarm();
    
  } // Gets the alarm

  public CORBAServer.Image CurrentImage ()
  {
    return _impl.CurrentImage();
    
  } // returns the current image

  private CORBAServer.CamCorbaOperations _impl;
  private org.omg.PortableServer.POA _poa;

} 
