package RegionalOffice;



abstract public class REGOFFHelper
{
  private static String  _id = "IDL:RegionalOffice/REGOFF:1.0";

  public static void insert (org.omg.CORBA.Any a, RegionalOffice.REGOFF that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static RegionalOffice.REGOFF extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (RegionalOffice.REGOFFHelper.id (), "REGOFF");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static RegionalOffice.REGOFF read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (REGOFFStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, RegionalOffice.REGOFF value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static RegionalOffice.REGOFF narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof RegionalOffice.REGOFF)
      return (RegionalOffice.REGOFF)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      RegionalOffice.REGOFFStub stub = new RegionalOffice.REGOFFStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static RegionalOffice.REGOFF unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof RegionalOffice.REGOFF)
      return (RegionalOffice.REGOFF)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      RegionalOffice.REGOFFStub stub = new RegionalOffice.REGOFFStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
