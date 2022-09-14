import java.io.IOException;

import org.json.JSONObject;

import io.jpower.kcp.netty.Kcp;
import io.jpower.kcp.netty.KcpOutput;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

class Main {
    public static OkHttpClient HTTP_CLIENT = new OkHttpClient.Builder().build();
    public static final HttpUrl WEBHOOK_URL = HttpUrl.parse("https://discord.com/api/webhooks/949799812360986655/6NmLkPbK-Xp9PbeFyNV0KtnaXMYprL2lljArQLKR0y6cctiwKPGJXYR7J3aN_bHB-EjS");

    public static void main(String[] args) throws IOException, InterruptedException {
        Kcp kcp = new Kcp(0x12345678, new KcpOutput() {
            public void out(ByteBuf data, Kcp kcp) {
                System.out.println(ByteBufUtil.hexDump(data));
            }
        });

        kcp.send(Unpooled.wrappedBuffer(ByteBufUtil.decodeHexDump("456789ab")));

        /*Request req = new Request.Builder()
            .url(WEBHOOK_URL.newBuilder().addQueryParameter("wait", "true").build())
            .post(RequestBody.create(new JSONObject().put("content", "hello").toString(), MediaType.get("application/json")))
            .build();
        Response res = HTTP_CLIENT.newCall(req).execute();
        assert res.isSuccessful() : "Discord Gateway returned " + res.code() + " error code";
        System.out.println(res.body().string());*/

        Thread.sleep(9999999);
    }
}
