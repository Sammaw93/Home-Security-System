package PoliceM;




public abstract class PolicePOA extends org.omg.PortableServer.Servant
 implements PoliceM.PoliceOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("viewCamera", new java.lang.Integer (0));
    _methods.put ("updateInterface", new java.lang.Integer (1));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // Police_Module/Police/viewCamera
       {
         String camera = in.read_string ();
         this.viewCamera (camera);
         out = $rh.createReply();
         break;
       }

       case 1:  // Police_Module/Police/updateInterface
       {
         String message = in.read_string ();
         this.updateInterface (message);
         out = $rh.createReply();
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:Police_Module/Police:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public Police _this() 
  {
    return PoliceHelper.narrow(
    super._this_object());
  }

  public Police _this(org.omg.CORBA.ORB orb) 
  {
    return PoliceHelper.narrow(
    super._this_object(orb));
  }


} 
