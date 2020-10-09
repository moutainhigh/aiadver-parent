package com.aiadver.api.asr.grpc;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.config.ReferenceConfigBase;

import java.util.concurrent.TimeUnit;

import static com.aiadver.api.asr.grpc.IatGrpc.getServiceDescriptor;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static org.apache.dubbo.common.constants.CommonConstants.DEFAULT_TIMEOUT;
import static org.apache.dubbo.common.constants.CommonConstants.TIMEOUT_KEY;

@javax.annotation.Generated(
        value = "by DubboGrpc generator",
        comments = "Source: asr.proto")
public final class DubboIatGrpc {
    private static final int METHODID_CREATE_REC = 0;

    private DubboIatGrpc() {
    }

    public static DubboIatStub getDubboStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions, URL url, ReferenceConfigBase<?> referenceConfig) {
        return new DubboIatStub(channel, callOptions, url, referenceConfig);
    }

    public interface IIat {
        /**
         * <pre>
         * 创建会话参数，只要求传一次，后续持续向服务端写音频时可以忽略（服务也不再解析）,详细说明见：sessionParam参数说明
         * </pre>
         */
        public io.grpc.stub.StreamObserver<com.aiadver.api.asr.grpc.Asr.IatRequest> createRec(io.grpc.stub.StreamObserver<com.aiadver.api.asr.grpc.Asr.IatResult> responseObserver);

    }

    public static class DubboIatStub implements IIat {

        protected URL url;
        protected ReferenceConfigBase<?> referenceConfig;

        protected IatGrpc.IatBlockingStub blockingStub;
        protected IatGrpc.IatFutureStub futureStub;
        protected IatGrpc.IatStub stub;

        public DubboIatStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions, URL url, ReferenceConfigBase<?> referenceConfig) {
            this.url = url;
            this.referenceConfig = referenceConfig;

            blockingStub = IatGrpc.newBlockingStub(channel).build(channel, callOptions);
            futureStub = IatGrpc.newFutureStub(channel).build(channel, callOptions);
            stub = IatGrpc.newStub(channel).build(channel, callOptions);
        }

        /**
         * <pre>
         * 创建会话参数，只要求传一次，后续持续向服务端写音频时可以忽略（服务也不再解析）,详细说明见：sessionParam参数说明
         * </pre>
         */
        public io.grpc.stub.StreamObserver<com.aiadver.api.asr.grpc.Asr.IatRequest> createRec(io.grpc.stub.StreamObserver<com.aiadver.api.asr.grpc.Asr.IatResult> responseObserver) {
            return stub
                    .withDeadlineAfter(url.getParameter(TIMEOUT_KEY, DEFAULT_TIMEOUT), TimeUnit.MILLISECONDS)
                    .createRec(responseObserver);
        }
    }

    public static abstract class IatImplBase implements io.grpc.BindableService, IIat {

        private IIat proxiedImpl;

        public final void setProxiedImpl(IIat proxiedImpl) {
            this.proxiedImpl = proxiedImpl;
        }

        public io.grpc.stub.StreamObserver<com.aiadver.api.asr.grpc.Asr.IatRequest> createRec(
                io.grpc.stub.StreamObserver<com.aiadver.api.asr.grpc.Asr.IatResult> responseObserver) {
            return asyncUnimplementedStreamingCall(com.aiadver.api.asr.grpc.IatGrpc.getCreateRecMethod(), responseObserver);
        }

        @java.lang.Override
        public final io.grpc.ServerServiceDefinition bindService() {
            return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
                    .addMethod(
                            com.aiadver.api.asr.grpc.IatGrpc.getCreateRecMethod(),
                            asyncBidiStreamingCall(
                                    new MethodHandlers<
                                            com.aiadver.api.asr.grpc.Asr.IatRequest,
                                            com.aiadver.api.asr.grpc.Asr.IatResult>(
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
        private final IIat serviceImpl;
        private final int methodId;

        MethodHandlers(IIat serviceImpl, int methodId) {
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
                            (io.grpc.stub.StreamObserver<com.aiadver.api.asr.grpc.Asr.IatResult>) responseObserver);
                default:
                    throw new java.lang.AssertionError();
            }
        }
    }

}
