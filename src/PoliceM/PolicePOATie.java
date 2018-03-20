package PoliceM;




public class PolicePOATie extends PolicePOA
{

  // Constructors

  public PolicePOATie ( PoliceM.PoliceOperations delegate ) {
      this._impl = delegate;
  }
  public PolicePOATie ( PoliceM.PoliceOperations delegate , org.omg.PortableServer.POA poa ) {
      this._impl = delegate;
      this._poa      = poa;
  }
  public PoliceM.PoliceOperations _delegate() {
      return this._impl;
  }
  public void _delegate (PoliceM.PoliceOperations delegate ) {
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
  public void viewCamera (String camera)
  
  // View the camera
  {
    _impl.viewCamera(camera);
  } 

  public void updateInterface (String message)
  
  // update the interface
  {
    _impl.updateInterface(message);
  } 

  private PoliceM.PoliceOperations _impl;
  private org.omg.PortableServer.POA _poa;

} 
