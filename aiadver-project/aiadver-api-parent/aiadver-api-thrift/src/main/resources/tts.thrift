namespace java com.aiadver.api.thrift.tts

struct TTSResult{
    1:i32 status_code,
    2:i32 synthStatus,
    3:binary result,
    4:i32 result_len,
}
service TTSServ{
    i32 tts_init(1:string username,2:string password,3:string login_params),
    i32 tts_put_text(1:string text,2:string ssb_params,3:string tts_params),
    TTSResult tts_get_result(),
}