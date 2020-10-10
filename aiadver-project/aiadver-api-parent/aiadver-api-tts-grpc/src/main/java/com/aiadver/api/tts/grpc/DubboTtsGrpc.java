package com.aiadver.api.tts.grpc;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.config.ReferenceConfigBase;

import java.util.concurrent.TimeUnit;

import static com.aiadver.api.tts.grpc.TtsGrpc.getServiceDescriptor;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static org.apache.dubbo.common.constants.CommonConstants.DEFAULT_TIMEOUT;
import static org.apache.dubbo.common.constants.CommonConstants.TIMEOUT_KEY;

@javax.annotation.Generated(
        value = "by DubboGrpc generator",
        comments = "Source: tts.proto")
public final class DubboTtsGrpc {
    private static final int METHODID_CREATE_REC = 0;

    private DubboTtsGrpc() {
    }

    public static DubboTtsStub getDubboStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions, URL url, ReferenceConfigBase<?> referenceConfig) {
        return new DubboTtsStub(channel, callOptions, url, referenceConfig);
    }

    public interface ITts {
        public io.grpc.stub.StreamObserver<com.aiadver.api.tts.grpc.TtsOuterClass.TtsRequest> createRec(io.grpc.stub.StreamObserver<com.aiadver.api.tts.grpc.TtsOuterClass.TtsResult> responseObserver);

    }

    public static class DubboTtsStub implements ITts {

        protected URL url;
        protected ReferenceConfigBase<?> referenceConfig;

        protected TtsGrpc.TtsBlockingStub blockingStub;
        protected TtsGrpc.TtsFutureStub futureStub;
        protected TtsGrpc.TtsStub stub;

        public DubboTtsStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions, URL url, ReferenceConfigBase<?> referenceConfig) {
            this.url = url;
            this.referenceConfig = referenceConfig;

            blockingStub = TtsGrpc.newBlockingStub(channel).build(channel, callOptions);
            futureStub = TtsGrpc.newFutureStub(channel).build(channel, callOptions);
            stub = TtsGrpc.newStub(channel).build(channel, callOptions);
        }

        public io.grpc.stub.StreamObserver<com.aiadver.api.tts.grpc.TtsOuterClass.TtsRequest> createRec(io.grpc.stub.StreamObserver<com.aiadver.api.tts.grpc.TtsOuterClass.TtsResult> responseObserver) {
            return stub
                    .withDeadlineAfter(url.getParameter(TIMEOUT_KEY, DEFAULT_TIMEOUT), TimeUnit.MILLISECONDS)
                    .createRec(responseObserver);
        }
    }

    public static abstract class TtsImplBase implements io.grpc.BindableService, ITts {

        private ITts proxiedImpl;

        public final void setProxiedImpl(ITts proxiedImpl) {
            this.proxiedImpl = proxiedImpl;
        }

        public io.grpc.stub.StreamObserver<com.aiadver.api.tts.grpc.TtsOuterClass.TtsRequest> createRec(
                io.grpc.stub.StreamObserver<com.aiadver.api.tts.grpc.TtsOuterClass.TtsResult> responseObserver) {
            return asyncUnimplementedStreamingCall(com.aiadver.api.tts.grpc.TtsGrpc.getCreateRecMethod(), responseObserver);
        }

        @java.lang.Override
        public final io.grpc.ServerServiceDefinition bindService() {
            return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
                    .addMethod(
                            com.aiadver.api.tts.grpc.TtsGrpc.getCreateRecMethod(),
                            asyncBidiStreamingCall(
                                    new MethodHandlers<
                                            com.aiadver.api.tts.grpc.TtsOuterClass.TtsRequest,
                                            com.aiadver.api.tts.grpc.TtsOuterClass.TtsResult>(
                                            proxiedImpl, METHODID_CREATE_REC)))
                    .build();
        }
    }

    private static final class MethodHandlers
            <Req, Resp> implements
            io.grpc.stub.ServerCalls.UnaryMethod
                    <Req, Resp>,
            io.grpc.stub.ServerCalls.ServerStreamingMethod
                    <Req, Resp>,
            io.grpc.stub.ServerCalls.ClientStreamingMethod
                    <Req, Resp>,
            io.grpc.stub.ServerCalls.BidiStreamingMethod
                    <Req, Resp> {
        private final ITts serviceImpl;
        private final int methodId;

        MethodHandlers(ITts serviceImpl, int methodId) {
            this.serviceImpl = serviceImpl;
            this.methodId = methodId;
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public void invoke(Req request, io.grpc.stub.StreamObserver
                <Resp> responseObserver) {
            switch (methodId) {
                default:
                    throw new java.lang.AssertionError();
            }
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public io.grpc.stub.StreamObserver
                <Req> invoke(io.grpc.stub.StreamObserver
                                     <Resp> responseObserver) {
            switch (methodId) {
                case METHODID_CREATE_REC:
                    return (io.grpc.stub.StreamObserver
                            <Req>) serviceImpl.createRec(
                            (io.grpc.stub.StreamObserver<com.aiadver.api.tts.grpc.TtsOuterClass.TtsResult>) responseObserver);
                default:
                    throw new java.lang.AssertionError();
            }
        }
    }

}
