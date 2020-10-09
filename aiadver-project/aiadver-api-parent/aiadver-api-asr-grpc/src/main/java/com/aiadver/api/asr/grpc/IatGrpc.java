package com.aiadver.api.asr.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 *
 */
@javax.annotation.Generated(
        value = "by gRPC proto compiler (version 1.30.2)",
        comments = "Source: asr.proto")
public final class IatGrpc {

    public static final String SERVICE_NAME = "iat.Iat";
    private static final int METHODID_CREATE_REC = 0;
    // Static method descriptors that strictly reflect the proto.
    private static volatile io.grpc.MethodDescriptor<com.aiadver.api.asr.grpc.Asr.IatRequest,
            com.aiadver.api.asr.grpc.Asr.IatResult> getCreateRecMethod;
    private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

    private IatGrpc() {
    }

    @io.grpc.stub.annotations.RpcMethod(
            fullMethodName = SERVICE_NAME + '/' + "createRec",
            requestType = com.aiadver.api.asr.grpc.Asr.IatRequest.class,
            responseType = com.aiadver.api.asr.grpc.Asr.IatResult.class,
            methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
    public static io.grpc.MethodDescriptor<com.aiadver.api.asr.grpc.Asr.IatRequest,
            com.aiadver.api.asr.grpc.Asr.IatResult> getCreateRecMethod() {
        io.grpc.MethodDescriptor<com.aiadver.api.asr.grpc.Asr.IatRequest, com.aiadver.api.asr.grpc.Asr.IatResult> getCreateRecMethod;
        if ((getCreateRecMethod = IatGrpc.getCreateRecMethod) == null) {
            synchronized (IatGrpc.class) {
                if ((getCreateRecMethod = IatGrpc.getCreateRecMethod) == null) {
                    IatGrpc.getCreateRecMethod = getCreateRecMethod =
                            io.grpc.MethodDescriptor.<com.aiadver.api.asr.grpc.Asr.IatRequest, com.aiadver.api.asr.grpc.Asr.IatResult>newBuilder()
                                    .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
                                    .setFullMethodName(generateFullMethodName(SERVICE_NAME, "createRec"))
                                    .setSampledToLocalTracing(true)
                                    .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            com.aiadver.api.asr.grpc.Asr.IatRequest.getDefaultInstance()))
                                    .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            com.aiadver.api.asr.grpc.Asr.IatResult.getDefaultInstance()))
                                    .setSchemaDescriptor(new IatMethodDescriptorSupplier("createRec"))
                                    .build();
                }
            }
        }
        return getCreateRecMethod;
    }

    /**
     * Creates a new async stub that supports all call types for the service
     */
    public static IatStub newStub(io.grpc.Channel channel) {
        io.grpc.stub.AbstractStub.StubFactory<IatStub> factory =
                new io.grpc.stub.AbstractStub.StubFactory<IatStub>() {
                    @java.lang.Override
                    public IatStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
                        return new IatStub(channel, callOptions);
                    }
                };
        return IatStub.newStub(factory, channel);
    }

    /**
     * Creates a new blocking-style stub that supports unary and streaming output calls on the service
     */
    public static IatBlockingStub newBlockingStub(
            io.grpc.Channel channel) {
        io.grpc.stub.AbstractStub.StubFactory<IatBlockingStub> factory =
                new io.grpc.stub.AbstractStub.StubFactory<IatBlockingStub>() {
                    @java.lang.Override
                    public IatBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
                        return new IatBlockingStub(channel, callOptions);
                    }
                };
        return IatBlockingStub.newStub(factory, channel);
    }

    /**
     * Creates a new ListenableFuture-style stub that supports unary calls on the service
     */
    public static IatFutureStub newFutureStub(
            io.grpc.Channel channel) {
        io.grpc.stub.AbstractStub.StubFactory<IatFutureStub> factory =
                new io.grpc.stub.AbstractStub.StubFactory<IatFutureStub>() {
                    @java.lang.Override
                    public IatFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
                        return new IatFutureStub(channel, callOptions);
                    }
                };
        return IatFutureStub.newStub(factory, channel);
    }

    public static io.grpc.ServiceDescriptor getServiceDescriptor() {
        io.grpc.ServiceDescriptor result = serviceDescriptor;
        if (result == null) {
            synchronized (IatGrpc.class) {
                result = serviceDescriptor;
                if (result == null) {
                    serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                            .setSchemaDescriptor(new IatFileDescriptorSupplier())
                            .addMethod(getCreateRecMethod())
                            .build();
                }
            }
        }
        return result;
    }

    /**
     *
     */
    public static abstract class IatImplBase implements io.grpc.BindableService {

        /**
         * <pre>
         * 采用流的方式持续向服务端写音频数据，及持续从服务端获得结果
         * 音频请求流,IatRequest.endFlag为true时代表写音频结束
         * 结果返回流,IatResult.endFlag为true时代表会话识别结束
         * </pre>
         */
        public io.grpc.stub.StreamObserver<com.aiadver.api.asr.grpc.Asr.IatRequest> createRec(
                io.grpc.stub.StreamObserver<com.aiadver.api.asr.grpc.Asr.IatResult> responseObserver) {
            return asyncUnimplementedStreamingCall(getCreateRecMethod(), responseObserver);
        }

        @java.lang.Override
        public final io.grpc.ServerServiceDefinition bindService() {
            return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
                    .addMethod(
                            getCreateRecMethod(),
                            asyncBidiStreamingCall(
                                    new MethodHandlers<
                                            com.aiadver.api.asr.grpc.Asr.IatRequest,
                                            com.aiadver.api.asr.grpc.Asr.IatResult>(
                                            this, METHODID_CREATE_REC)))
                    .build();
        }
    }

    /**
     *
     */
    public static final class IatStub extends io.grpc.stub.AbstractAsyncStub<IatStub> {
        private IatStub(
                io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @java.lang.Override
        protected IatStub build(
                io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new IatStub(channel, callOptions);
        }

        /**
         * <pre>
         * 采用流的方式持续向服务端写音频数据，及持续从服务端获得结果
         * 音频请求流,IatRequest.endFlag为true时代表写音频结束
         * 结果返回流,IatResult.endFlag为true时代表会话识别结束
         * </pre>
         */
        public io.grpc.stub.StreamObserver<com.aiadver.api.asr.grpc.Asr.IatRequest> createRec(
                io.grpc.stub.StreamObserver<com.aiadver.api.asr.grpc.Asr.IatResult> responseObserver) {
            return asyncBidiStreamingCall(
                    getChannel().newCall(getCreateRecMethod(), getCallOptions()), responseObserver);
        }
    }

    /**
     *
     */
    public static final class IatBlockingStub extends io.grpc.stub.AbstractBlockingStub<IatBlockingStub> {
        private IatBlockingStub(
                io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @java.lang.Override
        protected IatBlockingStub build(
                io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new IatBlockingStub(channel, callOptions);
        }
    }

    /**
     *
     */
    public static final class IatFutureStub extends io.grpc.stub.AbstractFutureStub<IatFutureStub> {
        private IatFutureStub(
                io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @java.lang.Override
        protected IatFutureStub build(
                io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new IatFutureStub(channel, callOptions);
        }
    }

    private static final class MethodHandlers<Req, Resp> implements
            io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
        private final IatImplBase serviceImpl;
        private final int methodId;

        MethodHandlers(IatImplBase serviceImpl, int methodId) {
            this.serviceImpl = serviceImpl;
            this.methodId = methodId;
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch (methodId) {
                default:
                    throw new AssertionError();
            }
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public io.grpc.stub.StreamObserver<Req> invoke(
                io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch (methodId) {
                case METHODID_CREATE_REC:
                    return (io.grpc.stub.StreamObserver<Req>) serviceImpl.createRec(
                            (io.grpc.stub.StreamObserver<com.aiadver.api.asr.grpc.Asr.IatResult>) responseObserver);
                default:
                    throw new AssertionError();
            }
        }
    }

    private static abstract class IatBaseDescriptorSupplier
            implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
        IatBaseDescriptorSupplier() {
        }

        @java.lang.Override
        public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
            return com.aiadver.api.asr.grpc.Asr.getDescriptor();
        }

        @java.lang.Override
        public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
            return getFileDescriptor().findServiceByName("Iat");
        }
    }

    private static final class IatFileDescriptorSupplier
            extends IatBaseDescriptorSupplier {
        IatFileDescriptorSupplier() {
        }
    }

    private static final class IatMethodDescriptorSupplier
            extends IatBaseDescriptorSupplier
            implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
        private final String methodName;

        IatMethodDescriptorSupplier(String methodName) {
            this.methodName = methodName;
        }

        @java.lang.Override
        public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
            return getServiceDescriptor().findMethodByName(methodName);
        }
    }
}
