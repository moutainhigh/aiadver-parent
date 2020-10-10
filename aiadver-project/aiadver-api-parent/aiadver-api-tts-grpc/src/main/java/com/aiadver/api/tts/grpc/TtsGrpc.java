package com.aiadver.api.tts.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 *
 */
@javax.annotation.Generated(
        value = "by gRPC proto compiler (version 1.30.2)",
        comments = "Source: tts.proto")
public final class TtsGrpc {

    public static final String SERVICE_NAME = "tts.Tts";
    private static final int METHODID_CREATE_REC = 0;
    // Static method descriptors that strictly reflect the proto.
    private static volatile io.grpc.MethodDescriptor<com.aiadver.api.tts.grpc.TtsOuterClass.TtsRequest,
            com.aiadver.api.tts.grpc.TtsOuterClass.TtsResult> getCreateRecMethod;
    private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

    private TtsGrpc() {
    }

    @io.grpc.stub.annotations.RpcMethod(
            fullMethodName = SERVICE_NAME + '/' + "createRec",
            requestType = com.aiadver.api.tts.grpc.TtsOuterClass.TtsRequest.class,
            responseType = com.aiadver.api.tts.grpc.TtsOuterClass.TtsResult.class,
            methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
    public static io.grpc.MethodDescriptor<com.aiadver.api.tts.grpc.TtsOuterClass.TtsRequest,
            com.aiadver.api.tts.grpc.TtsOuterClass.TtsResult> getCreateRecMethod() {
        io.grpc.MethodDescriptor<com.aiadver.api.tts.grpc.TtsOuterClass.TtsRequest, com.aiadver.api.tts.grpc.TtsOuterClass.TtsResult> getCreateRecMethod;
        if ((getCreateRecMethod = TtsGrpc.getCreateRecMethod) == null) {
            synchronized (TtsGrpc.class) {
                if ((getCreateRecMethod = TtsGrpc.getCreateRecMethod) == null) {
                    TtsGrpc.getCreateRecMethod = getCreateRecMethod =
                            io.grpc.MethodDescriptor.<com.aiadver.api.tts.grpc.TtsOuterClass.TtsRequest, com.aiadver.api.tts.grpc.TtsOuterClass.TtsResult>newBuilder()
                                    .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
                                    .setFullMethodName(generateFullMethodName(SERVICE_NAME, "createRec"))
                                    .setSampledToLocalTracing(true)
                                    .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            com.aiadver.api.tts.grpc.TtsOuterClass.TtsRequest.getDefaultInstance()))
                                    .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            com.aiadver.api.tts.grpc.TtsOuterClass.TtsResult.getDefaultInstance()))
                                    .setSchemaDescriptor(new TtsMethodDescriptorSupplier("createRec"))
                                    .build();
                }
            }
        }
        return getCreateRecMethod;
    }

    /**
     * Creates a new async stub that supports all call types for the service
     */
    public static TtsStub newStub(io.grpc.Channel channel) {
        io.grpc.stub.AbstractStub.StubFactory<TtsStub> factory =
                new io.grpc.stub.AbstractStub.StubFactory<TtsStub>() {
                    @java.lang.Override
                    public TtsStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
                        return new TtsStub(channel, callOptions);
                    }
                };
        return TtsStub.newStub(factory, channel);
    }

    /**
     * Creates a new blocking-style stub that supports unary and streaming output calls on the service
     */
    public static TtsBlockingStub newBlockingStub(
            io.grpc.Channel channel) {
        io.grpc.stub.AbstractStub.StubFactory<TtsBlockingStub> factory =
                new io.grpc.stub.AbstractStub.StubFactory<TtsBlockingStub>() {
                    @java.lang.Override
                    public TtsBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
                        return new TtsBlockingStub(channel, callOptions);
                    }
                };
        return TtsBlockingStub.newStub(factory, channel);
    }

    /**
     * Creates a new ListenableFuture-style stub that supports unary calls on the service
     */
    public static TtsFutureStub newFutureStub(
            io.grpc.Channel channel) {
        io.grpc.stub.AbstractStub.StubFactory<TtsFutureStub> factory =
                new io.grpc.stub.AbstractStub.StubFactory<TtsFutureStub>() {
                    @java.lang.Override
                    public TtsFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
                        return new TtsFutureStub(channel, callOptions);
                    }
                };
        return TtsFutureStub.newStub(factory, channel);
    }

    public static io.grpc.ServiceDescriptor getServiceDescriptor() {
        io.grpc.ServiceDescriptor result = serviceDescriptor;
        if (result == null) {
            synchronized (TtsGrpc.class) {
                result = serviceDescriptor;
                if (result == null) {
                    serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                            .setSchemaDescriptor(new TtsFileDescriptorSupplier())
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
    public static abstract class TtsImplBase implements io.grpc.BindableService {

        /**
         *
         */
        public io.grpc.stub.StreamObserver<com.aiadver.api.tts.grpc.TtsOuterClass.TtsRequest> createRec(
                io.grpc.stub.StreamObserver<com.aiadver.api.tts.grpc.TtsOuterClass.TtsResult> responseObserver) {
            return asyncUnimplementedStreamingCall(getCreateRecMethod(), responseObserver);
        }

        @java.lang.Override
        public final io.grpc.ServerServiceDefinition bindService() {
            return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
                    .addMethod(
                            getCreateRecMethod(),
                            asyncBidiStreamingCall(
                                    new MethodHandlers<
                                            com.aiadver.api.tts.grpc.TtsOuterClass.TtsRequest,
                                            com.aiadver.api.tts.grpc.TtsOuterClass.TtsResult>(
                                            this, METHODID_CREATE_REC)))
                    .build();
        }
    }

    /**
     *
     */
    public static final class TtsStub extends io.grpc.stub.AbstractAsyncStub<TtsStub> {
        private TtsStub(
                io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @java.lang.Override
        protected TtsStub build(
                io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new TtsStub(channel, callOptions);
        }

        /**
         *
         */
        public io.grpc.stub.StreamObserver<com.aiadver.api.tts.grpc.TtsOuterClass.TtsRequest> createRec(
                io.grpc.stub.StreamObserver<com.aiadver.api.tts.grpc.TtsOuterClass.TtsResult> responseObserver) {
            return asyncBidiStreamingCall(
                    getChannel().newCall(getCreateRecMethod(), getCallOptions()), responseObserver);
        }
    }

    /**
     *
     */
    public static final class TtsBlockingStub extends io.grpc.stub.AbstractBlockingStub<TtsBlockingStub> {
        private TtsBlockingStub(
                io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @java.lang.Override
        protected TtsBlockingStub build(
                io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new TtsBlockingStub(channel, callOptions);
        }
    }

    /**
     *
     */
    public static final class TtsFutureStub extends io.grpc.stub.AbstractFutureStub<TtsFutureStub> {
        private TtsFutureStub(
                io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @java.lang.Override
        protected TtsFutureStub build(
                io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new TtsFutureStub(channel, callOptions);
        }
    }

    private static final class MethodHandlers<Req, Resp> implements
            io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
        private final TtsImplBase serviceImpl;
        private final int methodId;

        MethodHandlers(TtsImplBase serviceImpl, int methodId) {
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
                            (io.grpc.stub.StreamObserver<com.aiadver.api.tts.grpc.TtsOuterClass.TtsResult>) responseObserver);
                default:
                    throw new AssertionError();
            }
        }
    }

    private static abstract class TtsBaseDescriptorSupplier
            implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
        TtsBaseDescriptorSupplier() {
        }

        @java.lang.Override
        public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
            return com.aiadver.api.tts.grpc.TtsOuterClass.getDescriptor();
        }

        @java.lang.Override
        public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
            return getFileDescriptor().findServiceByName("Tts");
        }
    }

    private static final class TtsFileDescriptorSupplier
            extends TtsBaseDescriptorSupplier {
        TtsFileDescriptorSupplier() {
        }
    }

    private static final class TtsMethodDescriptorSupplier
            extends TtsBaseDescriptorSupplier
            implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
        private final String methodName;

        TtsMethodDescriptorSupplier(String methodName) {
            this.methodName = methodName;
        }

        @java.lang.Override
        public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
            return getServiceDescriptor().findMethodByName(methodName);
        }
    }
}
