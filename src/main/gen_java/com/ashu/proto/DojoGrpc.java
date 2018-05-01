package com.ashu.proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.9.0)",
    comments = "Source: hello.proto")
public final class DojoGrpc {

  private DojoGrpc() {}

  public static final String SERVICE_NAME = "proto.Dojo";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWorkMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.ashu.proto.Hello.Input,
      com.ashu.proto.Hello.Return> METHOD_WORK = getWorkMethod();

  private static volatile io.grpc.MethodDescriptor<com.ashu.proto.Hello.Input,
      com.ashu.proto.Hello.Return> getWorkMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.ashu.proto.Hello.Input,
      com.ashu.proto.Hello.Return> getWorkMethod() {
    io.grpc.MethodDescriptor<com.ashu.proto.Hello.Input, com.ashu.proto.Hello.Return> getWorkMethod;
    if ((getWorkMethod = DojoGrpc.getWorkMethod) == null) {
      synchronized (DojoGrpc.class) {
        if ((getWorkMethod = DojoGrpc.getWorkMethod) == null) {
          DojoGrpc.getWorkMethod = getWorkMethod = 
              io.grpc.MethodDescriptor.<com.ashu.proto.Hello.Input, com.ashu.proto.Hello.Return>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "proto.Dojo", "Work"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ashu.proto.Hello.Input.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ashu.proto.Hello.Return.getDefaultInstance()))
                  .setSchemaDescriptor(new DojoMethodDescriptorSupplier("Work"))
                  .build();
          }
        }
     }
     return getWorkMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static DojoStub newStub(io.grpc.Channel channel) {
    return new DojoStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DojoBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new DojoBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static DojoFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new DojoFutureStub(channel);
  }

  /**
   */
  public static abstract class DojoImplBase implements io.grpc.BindableService {

    /**
     */
    public void work(com.ashu.proto.Hello.Input request,
        io.grpc.stub.StreamObserver<com.ashu.proto.Hello.Return> responseObserver) {
      asyncUnimplementedUnaryCall(getWorkMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getWorkMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.ashu.proto.Hello.Input,
                com.ashu.proto.Hello.Return>(
                  this, METHODID_WORK)))
          .build();
    }
  }

  /**
   */
  public static final class DojoStub extends io.grpc.stub.AbstractStub<DojoStub> {
    private DojoStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DojoStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DojoStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DojoStub(channel, callOptions);
    }

    /**
     */
    public void work(com.ashu.proto.Hello.Input request,
        io.grpc.stub.StreamObserver<com.ashu.proto.Hello.Return> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWorkMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class DojoBlockingStub extends io.grpc.stub.AbstractStub<DojoBlockingStub> {
    private DojoBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DojoBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DojoBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DojoBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.ashu.proto.Hello.Return work(com.ashu.proto.Hello.Input request) {
      return blockingUnaryCall(
          getChannel(), getWorkMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class DojoFutureStub extends io.grpc.stub.AbstractStub<DojoFutureStub> {
    private DojoFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DojoFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DojoFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DojoFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.ashu.proto.Hello.Return> work(
        com.ashu.proto.Hello.Input request) {
      return futureUnaryCall(
          getChannel().newCall(getWorkMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_WORK = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final DojoImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(DojoImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_WORK:
          serviceImpl.work((com.ashu.proto.Hello.Input) request,
              (io.grpc.stub.StreamObserver<com.ashu.proto.Hello.Return>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class DojoBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DojoBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.ashu.proto.Hello.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Dojo");
    }
  }

  private static final class DojoFileDescriptorSupplier
      extends DojoBaseDescriptorSupplier {
    DojoFileDescriptorSupplier() {}
  }

  private static final class DojoMethodDescriptorSupplier
      extends DojoBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    DojoMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (DojoGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new DojoFileDescriptorSupplier())
              .addMethod(getWorkMethod())
              .build();
        }
      }
    }
    return result;
  }
}
