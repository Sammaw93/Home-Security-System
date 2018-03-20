package UserM;




public abstract class UserPOA extends org.omg.PortableServer.Servant
 implements UserM.UserOperations, org.omg.CORBA.portable.InvokeHandler
{


  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("registerUser", new java.lang.Integer (0));
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
       case 0:  // User_Module/User/registerUser
       {
         String fullName = in.read_string ();
         String telePhone = in.read_string ();
         this.registerUser (fullName, telePhone);
         out = $rh.createReply();
         break;
       }

       case 1:  // User_Module/User/updateInterface
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
    "IDL:User_Module/User:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public User _this() 
  {
    return UserHelper.narrow(
    super._this_object());
  }

  public User _this(org.omg.CORBA.ORB orb) 
  {
    return UserHelper.narrow(
    super._this_object(orb));
  }


} // class UserPOA
