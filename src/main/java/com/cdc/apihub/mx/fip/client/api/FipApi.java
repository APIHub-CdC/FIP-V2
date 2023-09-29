package com.cdc.apihub.mx.fip.client.api;

import com.cdc.apihub.mx.fip.client.ApiCallback;
import com.cdc.apihub.mx.fip.client.ApiClient;
import com.cdc.apihub.mx.fip.client.ApiException;
import com.cdc.apihub.mx.fip.client.ApiResponse;
import com.cdc.apihub.mx.fip.client.Configuration;
import com.cdc.apihub.mx.fip.client.Pair;
import com.cdc.apihub.mx.fip.client.ProgressRequestBody;
import com.cdc.apihub.mx.fip.client.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;

import com.cdc.apihub.mx.fip.client.model.RequestDatosGenerales;
import com.cdc.apihub.mx.fip.client.model.ResponseScore;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FipApi {
    private ApiClient apiClient;
    public FipApi() {
        this(Configuration.getDefaultApiClient());
    }
    public FipApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }
    public ApiClient getApiClient() {
        return apiClient;
    }
    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }
    
    public okhttp3.Call devuelveelScoreFIPCall(String xApiKey, String username, String password, RequestDatosGenerales body, String contentType, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = body;
        String localVarPath = "/obtenerScore";
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        /*if (xSignature != null)
        localVarHeaderParams.put("x-signature", apiClient.parameterToString(xSignature));*/
        if (xApiKey != null)
        localVarHeaderParams.put("x-api-key", apiClient.parameterToString(xApiKey));
        if (username != null)
        localVarHeaderParams.put("username", apiClient.parameterToString(username));
        if (password != null)
        localVarHeaderParams.put("password", apiClient.parameterToString(password));
        if (contentType != null)
        localVarHeaderParams.put("Content-Type", apiClient.parameterToString(contentType));
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);
        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);
        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new okhttp3.Interceptor() {
                @Override
                public okhttp3.Response intercept(okhttp3.Interceptor.Chain chain) throws IOException {
                    okhttp3.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }
        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    @SuppressWarnings("rawtypes")
    private okhttp3.Call devuelveelScoreFIPValidateBeforeCall(String xApiKey, String username, String password, RequestDatosGenerales body, String contentType, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        /*if (xSignature == null) {
            throw new ApiException("Missing the required parameter 'xSignature' when calling devuelveelScoreFIP(Async)");
        }*/
        if (xApiKey == null) {
            throw new ApiException("Missing the required parameter 'xApiKey' when calling devuelveelScoreFIP(Async)");
        }
        if (username == null) {
            throw new ApiException("Missing the required parameter 'username' when calling devuelveelScoreFIP(Async)");
        }
        if (password == null) {
            throw new ApiException("Missing the required parameter 'password' when calling devuelveelScoreFIP(Async)");
        }
        if (body == null) {
            throw new ApiException("Missing the required parameter 'body' when calling devuelveelScoreFIP(Async)");
        }
        
        okhttp3.Call call = devuelveelScoreFIPCall(xApiKey, username, password, body, contentType, progressListener, progressRequestListener);
        return call;
    }
    
    public ResponseScore devuelveelScoreFIP(String xApiKey, String username, String password, RequestDatosGenerales body, String contentType) throws ApiException {
        ApiResponse<ResponseScore> resp = devuelveelScoreFIPWithHttpInfo(xApiKey, username, password, body, contentType);
        return resp.getData();
    }
    
    public ApiResponse<ResponseScore> devuelveelScoreFIPWithHttpInfo(String xApiKey, String username, String password, RequestDatosGenerales body, String contentType) throws ApiException {
        okhttp3.Call call = devuelveelScoreFIPValidateBeforeCall(xApiKey, username, password, body, contentType, null, null);
        Type localVarReturnType = new TypeToken<ResponseScore>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }
    
    public okhttp3.Call devuelveelScoreFIPAsync(String xSignature, String xApiKey, String username, String password, RequestDatosGenerales body, String contentType, final ApiCallback<ResponseScore> callback) throws ApiException {
        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;
        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };
            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }
        okhttp3.Call call = devuelveelScoreFIPValidateBeforeCall(xApiKey, username, password, body, contentType, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ResponseScore>(){}.getType();
        apiClient.execute(call, localVarReturnType);
        return call;
    }
}
