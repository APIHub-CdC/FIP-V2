package com.cdc.apihub.mx.fip.client.api;

import com.cdc.apihub.mx.fip.client.ApiClient;
import com.cdc.apihub.mx.fip.client.model.RequestDatosGenerales;
import com.cdc.apihub.mx.fip.client.model.ResponseScore;
import com.cdc.apihub.mx.fip.interceptor.SignerInterceptor;
import okhttp3.OkHttpClient;
import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

@Ignore
public class FipApiTest {
    private Logger logger = LoggerFactory.getLogger(FipApiTest.class.getName());
    private final FipApi api = new FipApi();
    private ApiClient apiClient = null;

    private String keystoreFile = "/keystore.jks";//CHANGE IT TO YOUR KEYSTORE PATH
    private String cdcCertFile = "/cdc_cert.pem"; //CHANGE IT TO YOUR CDC CERTIFICATE PATH
    private String keystorePassword = "keystore_password"; //CHANGE IT TO YOUR KEYSTORE PASSWORD
    private String keyAlias = "key_alias"; //CHANGE IT TO YOUR KEY ALIAS
    private String keyPassword = "key_password"; //CHANGE IT TO YOUR KEY PASSWORD

    private String usernameCDC = "username"; //CHANGE IT TO YOUR CDC USERNAME
    private String passwordCDC = "password"; //CHANGE IT TO YOUR CDC PASSWORD

    private String url = "https://circulodecredito-dev.apigee.net/v2/fip";
    private String xApiKey = "your_apikey"; //CHANGE IT TO YOUR API KEY


    private SignerInterceptor interceptor;

    @Before()
    public void Setup() {
        this.apiClient = api.getApiClient();
        this.apiClient.setBasePath(url);
        OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                .readTimeout(30, TimeUnit.SECONDS)
                .addInterceptor(new SignerInterceptor(
                        keystoreFile,
                        cdcCertFile,
                        keystorePassword,
                        keyAlias,
                        keyPassword))
                .build();
        apiClient.setHttpClient(okHttpClient);
    }
    
    
    @Test
    public void devuelveelScoreFIPTest() throws Exception {

        RequestDatosGenerales requestDatosGenerales = new RequestDatosGenerales();
        requestDatosGenerales.setPrimerNombre("PEDRO");
        requestDatosGenerales.setApellidoPaterno("GARZA");
        requestDatosGenerales.setApellidoMaterno("GARCIA");
        requestDatosGenerales.setFechaNacimiento("31-12-1985");
        requestDatosGenerales.setDireccion("INSURGENTES SUR 1007");
        requestDatosGenerales.setColoniaPoblacion("INSURGENTES");
        requestDatosGenerales.setCiudad("MEXICO");
        requestDatosGenerales.setEstado("DF");
        requestDatosGenerales.setPais("MEX");
        requestDatosGenerales.setDelegacionMunicipio("BENITO JUAREZ");
        requestDatosGenerales.setCp("11230");
        requestDatosGenerales.setRfc("GAGP8512318Z2");

        String contentType = "application/json";

        ResponseScore response = api.devuelveelScoreFIP( xApiKey, usernameCDC, passwordCDC, requestDatosGenerales, contentType);
        logger.info(response.toString());
    }
    
}
