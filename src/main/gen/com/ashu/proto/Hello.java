// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: hello.proto

package com.ashu.proto;

public final class Hello {
  private Hello() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface InputOrBuilder extends
      // @@protoc_insertion_point(interface_extends:proto.Input)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>int32 time = 1;</code>
     */
    int getTime();

    /**
     * <code>int32 state = 2;</code>
     */
    int getState();
  }
  /**
   * Protobuf type {@code proto.Input}
   */
  public  static final class Input extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:proto.Input)
      InputOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use Input.newBuilder() to construct.
    private Input(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private Input() {
      time_ = 0;
      state_ = 0;
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private Input(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      int mutable_bitField0_ = 0;
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!parseUnknownFieldProto3(
                  input, unknownFields, extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
            case 8: {

              time_ = input.readInt32();
              break;
            }
            case 16: {

              state_ = input.readInt32();
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.ashu.proto.Hello.internal_static_proto_Input_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.ashu.proto.Hello.internal_static_proto_Input_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.ashu.proto.Hello.Input.class, com.ashu.proto.Hello.Input.Builder.class);
    }

    public static final int TIME_FIELD_NUMBER = 1;
    private int time_;
    /**
     * <code>int32 time = 1;</code>
     */
    public int getTime() {
      return time_;
    }

    public static final int STATE_FIELD_NUMBER = 2;
    private int state_;
    /**
     * <code>int32 state = 2;</code>
     */
    public int getState() {
      return state_;
    }

    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (time_ != 0) {
        output.writeInt32(1, time_);
      }
      if (state_ != 0) {
        output.writeInt32(2, state_);
      }
      unknownFields.writeTo(output);
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (time_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(1, time_);
      }
      if (state_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(2, state_);
      }
      size += unknownFields.getSerializedSize();
      memoizedSize = size;
      return size;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof com.ashu.proto.Hello.Input)) {
        return super.equals(obj);
      }
      com.ashu.proto.Hello.Input other = (com.ashu.proto.Hello.Input) obj;

      boolean result = true;
      result = result && (getTime()
          == other.getTime());
      result = result && (getState()
          == other.getState());
      result = result && unknownFields.equals(other.unknownFields);
      return result;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      hash = (37 * hash) + TIME_FIELD_NUMBER;
      hash = (53 * hash) + getTime();
      hash = (37 * hash) + STATE_FIELD_NUMBER;
      hash = (53 * hash) + getState();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.ashu.proto.Hello.Input parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.ashu.proto.Hello.Input parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.ashu.proto.Hello.Input parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.ashu.proto.Hello.Input parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.ashu.proto.Hello.Input parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.ashu.proto.Hello.Input parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.ashu.proto.Hello.Input parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.ashu.proto.Hello.Input parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.ashu.proto.Hello.Input parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static com.ashu.proto.Hello.Input parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.ashu.proto.Hello.Input parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.ashu.proto.Hello.Input parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(com.ashu.proto.Hello.Input prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code proto.Input}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:proto.Input)
        com.ashu.proto.Hello.InputOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return com.ashu.proto.Hello.internal_static_proto_Input_descriptor;
      }

      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.ashu.proto.Hello.internal_static_proto_Input_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.ashu.proto.Hello.Input.class, com.ashu.proto.Hello.Input.Builder.class);
      }

      // Construct using com.ashu.proto.Hello.Input.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      public Builder clear() {
        super.clear();
        time_ = 0;

        state_ = 0;

        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.ashu.proto.Hello.internal_static_proto_Input_descriptor;
      }

      public com.ashu.proto.Hello.Input getDefaultInstanceForType() {
        return com.ashu.proto.Hello.Input.getDefaultInstance();
      }

      public com.ashu.proto.Hello.Input build() {
        com.ashu.proto.Hello.Input result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public com.ashu.proto.Hello.Input buildPartial() {
        com.ashu.proto.Hello.Input result = new com.ashu.proto.Hello.Input(this);
        result.time_ = time_;
        result.state_ = state_;
        onBuilt();
        return result;
      }

      public Builder clone() {
        return (Builder) super.clone();
      }
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return (Builder) super.setField(field, value);
      }
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return (Builder) super.clearField(field);
      }
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return (Builder) super.clearOneof(oneof);
      }
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, java.lang.Object value) {
        return (Builder) super.setRepeatedField(field, index, value);
      }
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return (Builder) super.addRepeatedField(field, value);
      }
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof com.ashu.proto.Hello.Input) {
          return mergeFrom((com.ashu.proto.Hello.Input)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.ashu.proto.Hello.Input other) {
        if (other == com.ashu.proto.Hello.Input.getDefaultInstance()) return this;
        if (other.getTime() != 0) {
          setTime(other.getTime());
        }
        if (other.getState() != 0) {
          setState(other.getState());
        }
        this.mergeUnknownFields(other.unknownFields);
        onChanged();
        return this;
      }

      public final boolean isInitialized() {
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        com.ashu.proto.Hello.Input parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (com.ashu.proto.Hello.Input) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private int time_ ;
      /**
       * <code>int32 time = 1;</code>
       */
      public int getTime() {
        return time_;
      }
      /**
       * <code>int32 time = 1;</code>
       */
      public Builder setTime(int value) {
        
        time_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int32 time = 1;</code>
       */
      public Builder clearTime() {
        
        time_ = 0;
        onChanged();
        return this;
      }

      private int state_ ;
      /**
       * <code>int32 state = 2;</code>
       */
      public int getState() {
        return state_;
      }
      /**
       * <code>int32 state = 2;</code>
       */
      public Builder setState(int value) {
        
        state_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int32 state = 2;</code>
       */
      public Builder clearState() {
        
        state_ = 0;
        onChanged();
        return this;
      }
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFieldsProto3(unknownFields);
      }

      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }


      // @@protoc_insertion_point(builder_scope:proto.Input)
    }

    // @@protoc_insertion_point(class_scope:proto.Input)
    private static final com.ashu.proto.Hello.Input DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new com.ashu.proto.Hello.Input();
    }

    public static com.ashu.proto.Hello.Input getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<Input>
        PARSER = new com.google.protobuf.AbstractParser<Input>() {
      public Input parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new Input(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<Input> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<Input> getParserForType() {
      return PARSER;
    }

    public com.ashu.proto.Hello.Input getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  public interface ReturnOrBuilder extends
      // @@protoc_insertion_point(interface_extends:proto.Return)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>int32 money = 1;</code>
     */
    int getMoney();

    /**
     * <code>string honorary = 2;</code>
     */
    java.lang.String getHonorary();
    /**
     * <code>string honorary = 2;</code>
     */
    com.google.protobuf.ByteString
        getHonoraryBytes();
  }
  /**
   * Protobuf type {@code proto.Return}
   */
  public  static final class Return extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:proto.Return)
      ReturnOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use Return.newBuilder() to construct.
    private Return(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private Return() {
      money_ = 0;
      honorary_ = "";
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private Return(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      int mutable_bitField0_ = 0;
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!parseUnknownFieldProto3(
                  input, unknownFields, extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
            case 8: {

              money_ = input.readInt32();
              break;
            }
            case 18: {
              java.lang.String s = input.readStringRequireUtf8();

              honorary_ = s;
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.ashu.proto.Hello.internal_static_proto_Return_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.ashu.proto.Hello.internal_static_proto_Return_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.ashu.proto.Hello.Return.class, com.ashu.proto.Hello.Return.Builder.class);
    }

    public static final int MONEY_FIELD_NUMBER = 1;
    private int money_;
    /**
     * <code>int32 money = 1;</code>
     */
    public int getMoney() {
      return money_;
    }

    public static final int HONORARY_FIELD_NUMBER = 2;
    private volatile java.lang.Object honorary_;
    /**
     * <code>string honorary = 2;</code>
     */
    public java.lang.String getHonorary() {
      java.lang.Object ref = honorary_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        honorary_ = s;
        return s;
      }
    }
    /**
     * <code>string honorary = 2;</code>
     */
    public com.google.protobuf.ByteString
        getHonoraryBytes() {
      java.lang.Object ref = honorary_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        honorary_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (money_ != 0) {
        output.writeInt32(1, money_);
      }
      if (!getHonoraryBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 2, honorary_);
      }
      unknownFields.writeTo(output);
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (money_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(1, money_);
      }
      if (!getHonoraryBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, honorary_);
      }
      size += unknownFields.getSerializedSize();
      memoizedSize = size;
      return size;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof com.ashu.proto.Hello.Return)) {
        return super.equals(obj);
      }
      com.ashu.proto.Hello.Return other = (com.ashu.proto.Hello.Return) obj;

      boolean result = true;
      result = result && (getMoney()
          == other.getMoney());
      result = result && getHonorary()
          .equals(other.getHonorary());
      result = result && unknownFields.equals(other.unknownFields);
      return result;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      hash = (37 * hash) + MONEY_FIELD_NUMBER;
      hash = (53 * hash) + getMoney();
      hash = (37 * hash) + HONORARY_FIELD_NUMBER;
      hash = (53 * hash) + getHonorary().hashCode();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.ashu.proto.Hello.Return parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.ashu.proto.Hello.Return parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.ashu.proto.Hello.Return parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.ashu.proto.Hello.Return parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.ashu.proto.Hello.Return parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.ashu.proto.Hello.Return parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.ashu.proto.Hello.Return parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.ashu.proto.Hello.Return parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.ashu.proto.Hello.Return parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static com.ashu.proto.Hello.Return parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.ashu.proto.Hello.Return parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.ashu.proto.Hello.Return parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(com.ashu.proto.Hello.Return prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code proto.Return}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:proto.Return)
        com.ashu.proto.Hello.ReturnOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return com.ashu.proto.Hello.internal_static_proto_Return_descriptor;
      }

      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.ashu.proto.Hello.internal_static_proto_Return_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.ashu.proto.Hello.Return.class, com.ashu.proto.Hello.Return.Builder.class);
      }

      // Construct using com.ashu.proto.Hello.Return.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      public Builder clear() {
        super.clear();
        money_ = 0;

        honorary_ = "";

        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.ashu.proto.Hello.internal_static_proto_Return_descriptor;
      }

      public com.ashu.proto.Hello.Return getDefaultInstanceForType() {
        return com.ashu.proto.Hello.Return.getDefaultInstance();
      }

      public com.ashu.proto.Hello.Return build() {
        com.ashu.proto.Hello.Return result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public com.ashu.proto.Hello.Return buildPartial() {
        com.ashu.proto.Hello.Return result = new com.ashu.proto.Hello.Return(this);
        result.money_ = money_;
        result.honorary_ = honorary_;
        onBuilt();
        return result;
      }

      public Builder clone() {
        return (Builder) super.clone();
      }
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return (Builder) super.setField(field, value);
      }
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return (Builder) super.clearField(field);
      }
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return (Builder) super.clearOneof(oneof);
      }
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, java.lang.Object value) {
        return (Builder) super.setRepeatedField(field, index, value);
      }
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return (Builder) super.addRepeatedField(field, value);
      }
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof com.ashu.proto.Hello.Return) {
          return mergeFrom((com.ashu.proto.Hello.Return)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.ashu.proto.Hello.Return other) {
        if (other == com.ashu.proto.Hello.Return.getDefaultInstance()) return this;
        if (other.getMoney() != 0) {
          setMoney(other.getMoney());
        }
        if (!other.getHonorary().isEmpty()) {
          honorary_ = other.honorary_;
          onChanged();
        }
        this.mergeUnknownFields(other.unknownFields);
        onChanged();
        return this;
      }

      public final boolean isInitialized() {
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        com.ashu.proto.Hello.Return parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (com.ashu.proto.Hello.Return) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private int money_ ;
      /**
       * <code>int32 money = 1;</code>
       */
      public int getMoney() {
        return money_;
      }
      /**
       * <code>int32 money = 1;</code>
       */
      public Builder setMoney(int value) {
        
        money_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int32 money = 1;</code>
       */
      public Builder clearMoney() {
        
        money_ = 0;
        onChanged();
        return this;
      }

      private java.lang.Object honorary_ = "";
      /**
       * <code>string honorary = 2;</code>
       */
      public java.lang.String getHonorary() {
        java.lang.Object ref = honorary_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          honorary_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string honorary = 2;</code>
       */
      public com.google.protobuf.ByteString
          getHonoraryBytes() {
        java.lang.Object ref = honorary_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          honorary_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string honorary = 2;</code>
       */
      public Builder setHonorary(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        honorary_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string honorary = 2;</code>
       */
      public Builder clearHonorary() {
        
        honorary_ = getDefaultInstance().getHonorary();
        onChanged();
        return this;
      }
      /**
       * <code>string honorary = 2;</code>
       */
      public Builder setHonoraryBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        honorary_ = value;
        onChanged();
        return this;
      }
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFieldsProto3(unknownFields);
      }

      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }


      // @@protoc_insertion_point(builder_scope:proto.Return)
    }

    // @@protoc_insertion_point(class_scope:proto.Return)
    private static final com.ashu.proto.Hello.Return DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new com.ashu.proto.Hello.Return();
    }

    public static com.ashu.proto.Hello.Return getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<Return>
        PARSER = new com.google.protobuf.AbstractParser<Return>() {
      public Return parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new Return(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<Return> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<Return> getParserForType() {
      return PARSER;
    }

    public com.ashu.proto.Hello.Return getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_proto_Input_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_proto_Input_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_proto_Return_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_proto_Return_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\013hello.proto\022\005proto\"$\n\005Input\022\014\n\004time\030\001 " +
      "\001(\005\022\r\n\005state\030\002 \001(\005\")\n\006Return\022\r\n\005money\030\001 " +
      "\001(\005\022\020\n\010honorary\030\002 \001(\t2-\n\004Dojo\022%\n\004Work\022\014." +
      "proto.Input\032\r.proto.Return\"\000B\020\n\016com.ashu" +
      ".protob\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_proto_Input_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_proto_Input_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_proto_Input_descriptor,
        new java.lang.String[] { "Time", "State", });
    internal_static_proto_Return_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_proto_Return_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_proto_Return_descriptor,
        new java.lang.String[] { "Money", "Honorary", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
