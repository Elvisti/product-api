/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.productapi.avros;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class ProductRequest extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 5015199586186817418L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"ProductRequest\",\"namespace\":\"com.productapi.avros\",\"fields\":[{\"name\":\"requestIdentification\",\"type\":{\"type\":\"record\",\"name\":\"RequestIdentification\",\"fields\":[{\"name\":\"id\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"instanceID\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}}]}},{\"name\":\"productCommand\",\"type\":{\"type\":\"record\",\"name\":\"ProductCommand\",\"fields\":[{\"name\":\"name\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"value\",\"type\":[\"null\",\"int\"],\"default\":null},{\"name\":\"code\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null}]}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<ProductRequest> ENCODER =
      new BinaryMessageEncoder<ProductRequest>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<ProductRequest> DECODER =
      new BinaryMessageDecoder<ProductRequest>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<ProductRequest> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<ProductRequest> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<ProductRequest> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<ProductRequest>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this ProductRequest to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a ProductRequest from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a ProductRequest instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static ProductRequest fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

   private com.productapi.avros.RequestIdentification requestIdentification;
   private com.productapi.avros.ProductCommand productCommand;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public ProductRequest() {}

  /**
   * All-args constructor.
   * @param requestIdentification The new value for requestIdentification
   * @param productCommand The new value for productCommand
   */
  public ProductRequest(com.productapi.avros.RequestIdentification requestIdentification, com.productapi.avros.ProductCommand productCommand) {
    this.requestIdentification = requestIdentification;
    this.productCommand = productCommand;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return requestIdentification;
    case 1: return productCommand;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: requestIdentification = (com.productapi.avros.RequestIdentification)value$; break;
    case 1: productCommand = (com.productapi.avros.ProductCommand)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'requestIdentification' field.
   * @return The value of the 'requestIdentification' field.
   */
  public com.productapi.avros.RequestIdentification getRequestIdentification() {
    return requestIdentification;
  }



  /**
   * Gets the value of the 'productCommand' field.
   * @return The value of the 'productCommand' field.
   */
  public com.productapi.avros.ProductCommand getProductCommand() {
    return productCommand;
  }



  /**
   * Creates a new ProductRequest RecordBuilder.
   * @return A new ProductRequest RecordBuilder
   */
  public static com.productapi.avros.ProductRequest.Builder newBuilder() {
    return new com.productapi.avros.ProductRequest.Builder();
  }

  /**
   * Creates a new ProductRequest RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new ProductRequest RecordBuilder
   */
  public static com.productapi.avros.ProductRequest.Builder newBuilder(com.productapi.avros.ProductRequest.Builder other) {
    if (other == null) {
      return new com.productapi.avros.ProductRequest.Builder();
    } else {
      return new com.productapi.avros.ProductRequest.Builder(other);
    }
  }

  /**
   * Creates a new ProductRequest RecordBuilder by copying an existing ProductRequest instance.
   * @param other The existing instance to copy.
   * @return A new ProductRequest RecordBuilder
   */
  public static com.productapi.avros.ProductRequest.Builder newBuilder(com.productapi.avros.ProductRequest other) {
    if (other == null) {
      return new com.productapi.avros.ProductRequest.Builder();
    } else {
      return new com.productapi.avros.ProductRequest.Builder(other);
    }
  }

  /**
   * RecordBuilder for ProductRequest instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<ProductRequest>
    implements org.apache.avro.data.RecordBuilder<ProductRequest> {

    private com.productapi.avros.RequestIdentification requestIdentification;
    private com.productapi.avros.RequestIdentification.Builder requestIdentificationBuilder;
    private com.productapi.avros.ProductCommand productCommand;
    private com.productapi.avros.ProductCommand.Builder productCommandBuilder;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.productapi.avros.ProductRequest.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.requestIdentification)) {
        this.requestIdentification = data().deepCopy(fields()[0].schema(), other.requestIdentification);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (other.hasRequestIdentificationBuilder()) {
        this.requestIdentificationBuilder = com.productapi.avros.RequestIdentification.newBuilder(other.getRequestIdentificationBuilder());
      }
      if (isValidValue(fields()[1], other.productCommand)) {
        this.productCommand = data().deepCopy(fields()[1].schema(), other.productCommand);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (other.hasProductCommandBuilder()) {
        this.productCommandBuilder = com.productapi.avros.ProductCommand.newBuilder(other.getProductCommandBuilder());
      }
    }

    /**
     * Creates a Builder by copying an existing ProductRequest instance
     * @param other The existing instance to copy.
     */
    private Builder(com.productapi.avros.ProductRequest other) {
      super(SCHEMA$);
      if (isValidValue(fields()[0], other.requestIdentification)) {
        this.requestIdentification = data().deepCopy(fields()[0].schema(), other.requestIdentification);
        fieldSetFlags()[0] = true;
      }
      this.requestIdentificationBuilder = null;
      if (isValidValue(fields()[1], other.productCommand)) {
        this.productCommand = data().deepCopy(fields()[1].schema(), other.productCommand);
        fieldSetFlags()[1] = true;
      }
      this.productCommandBuilder = null;
    }

    /**
      * Gets the value of the 'requestIdentification' field.
      * @return The value.
      */
    public com.productapi.avros.RequestIdentification getRequestIdentification() {
      return requestIdentification;
    }


    /**
      * Sets the value of the 'requestIdentification' field.
      * @param value The value of 'requestIdentification'.
      * @return This builder.
      */
    public com.productapi.avros.ProductRequest.Builder setRequestIdentification(com.productapi.avros.RequestIdentification value) {
      validate(fields()[0], value);
      this.requestIdentificationBuilder = null;
      this.requestIdentification = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'requestIdentification' field has been set.
      * @return True if the 'requestIdentification' field has been set, false otherwise.
      */
    public boolean hasRequestIdentification() {
      return fieldSetFlags()[0];
    }

    /**
     * Gets the Builder instance for the 'requestIdentification' field and creates one if it doesn't exist yet.
     * @return This builder.
     */
    public com.productapi.avros.RequestIdentification.Builder getRequestIdentificationBuilder() {
      if (requestIdentificationBuilder == null) {
        if (hasRequestIdentification()) {
          setRequestIdentificationBuilder(com.productapi.avros.RequestIdentification.newBuilder(requestIdentification));
        } else {
          setRequestIdentificationBuilder(com.productapi.avros.RequestIdentification.newBuilder());
        }
      }
      return requestIdentificationBuilder;
    }

    /**
     * Sets the Builder instance for the 'requestIdentification' field
     * @param value The builder instance that must be set.
     * @return This builder.
     */

    public com.productapi.avros.ProductRequest.Builder setRequestIdentificationBuilder(com.productapi.avros.RequestIdentification.Builder value) {
      clearRequestIdentification();
      requestIdentificationBuilder = value;
      return this;
    }

    /**
     * Checks whether the 'requestIdentification' field has an active Builder instance
     * @return True if the 'requestIdentification' field has an active Builder instance
     */
    public boolean hasRequestIdentificationBuilder() {
      return requestIdentificationBuilder != null;
    }

    /**
      * Clears the value of the 'requestIdentification' field.
      * @return This builder.
      */
    public com.productapi.avros.ProductRequest.Builder clearRequestIdentification() {
      requestIdentification = null;
      requestIdentificationBuilder = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'productCommand' field.
      * @return The value.
      */
    public com.productapi.avros.ProductCommand getProductCommand() {
      return productCommand;
    }


    /**
      * Sets the value of the 'productCommand' field.
      * @param value The value of 'productCommand'.
      * @return This builder.
      */
    public com.productapi.avros.ProductRequest.Builder setProductCommand(com.productapi.avros.ProductCommand value) {
      validate(fields()[1], value);
      this.productCommandBuilder = null;
      this.productCommand = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'productCommand' field has been set.
      * @return True if the 'productCommand' field has been set, false otherwise.
      */
    public boolean hasProductCommand() {
      return fieldSetFlags()[1];
    }

    /**
     * Gets the Builder instance for the 'productCommand' field and creates one if it doesn't exist yet.
     * @return This builder.
     */
    public com.productapi.avros.ProductCommand.Builder getProductCommandBuilder() {
      if (productCommandBuilder == null) {
        if (hasProductCommand()) {
          setProductCommandBuilder(com.productapi.avros.ProductCommand.newBuilder(productCommand));
        } else {
          setProductCommandBuilder(com.productapi.avros.ProductCommand.newBuilder());
        }
      }
      return productCommandBuilder;
    }

    /**
     * Sets the Builder instance for the 'productCommand' field
     * @param value The builder instance that must be set.
     * @return This builder.
     */

    public com.productapi.avros.ProductRequest.Builder setProductCommandBuilder(com.productapi.avros.ProductCommand.Builder value) {
      clearProductCommand();
      productCommandBuilder = value;
      return this;
    }

    /**
     * Checks whether the 'productCommand' field has an active Builder instance
     * @return True if the 'productCommand' field has an active Builder instance
     */
    public boolean hasProductCommandBuilder() {
      return productCommandBuilder != null;
    }

    /**
      * Clears the value of the 'productCommand' field.
      * @return This builder.
      */
    public com.productapi.avros.ProductRequest.Builder clearProductCommand() {
      productCommand = null;
      productCommandBuilder = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public ProductRequest build() {
      try {
        ProductRequest record = new ProductRequest();
        if (requestIdentificationBuilder != null) {
          try {
            record.requestIdentification = this.requestIdentificationBuilder.build();
          } catch (org.apache.avro.AvroMissingFieldException e) {
            e.addParentField(record.getSchema().getField("requestIdentification"));
            throw e;
          }
        } else {
          record.requestIdentification = fieldSetFlags()[0] ? this.requestIdentification : (com.productapi.avros.RequestIdentification) defaultValue(fields()[0]);
        }
        if (productCommandBuilder != null) {
          try {
            record.productCommand = this.productCommandBuilder.build();
          } catch (org.apache.avro.AvroMissingFieldException e) {
            e.addParentField(record.getSchema().getField("productCommand"));
            throw e;
          }
        } else {
          record.productCommand = fieldSetFlags()[1] ? this.productCommand : (com.productapi.avros.ProductCommand) defaultValue(fields()[1]);
        }
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<ProductRequest>
    WRITER$ = (org.apache.avro.io.DatumWriter<ProductRequest>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<ProductRequest>
    READER$ = (org.apache.avro.io.DatumReader<ProductRequest>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    this.requestIdentification.customEncode(out);

    this.productCommand.customEncode(out);

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      if (this.requestIdentification == null) {
        this.requestIdentification = new com.productapi.avros.RequestIdentification();
      }
      this.requestIdentification.customDecode(in);

      if (this.productCommand == null) {
        this.productCommand = new com.productapi.avros.ProductCommand();
      }
      this.productCommand.customDecode(in);

    } else {
      for (int i = 0; i < 2; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          if (this.requestIdentification == null) {
            this.requestIdentification = new com.productapi.avros.RequestIdentification();
          }
          this.requestIdentification.customDecode(in);
          break;

        case 1:
          if (this.productCommand == null) {
            this.productCommand = new com.productapi.avros.ProductCommand();
          }
          this.productCommand.customDecode(in);
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










