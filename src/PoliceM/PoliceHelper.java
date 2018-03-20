package PoliceM;




abstract public class PoliceHelper
{
  private static String  _id = "IDL:PoliceM/Police:1.0";

  public static void insert (org.omg.CORBA.Any a, PoliceM.Police that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static PoliceM.Police extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (PoliceM.PoliceHelper.id (), "Police");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static PoliceM.Police read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (PoliceStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, PoliceM.Police value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static PoliceM.Police narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof PoliceM.Police)
      return (PoliceM.Police)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      PoliceM.PoliceStub stub = new PoliceM.PoliceStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static PoliceM.Police unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof PoliceM.Police)
      return (PoliceM.Police)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      PoliceM.PoliceStub stub = new PoliceM.PoliceStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
