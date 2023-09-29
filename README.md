# FIS Financial Index Profile

FIP Financial Index Profile, developed by Círculo de Crédito, allows you to identify different levels of credit maturity, with the aim of understanding what type of product or service is the most appropriate to offer to each client.

## Requirements

Building the API client library requires:
1. Java 1.7+
2. Maven/Gradle

## Installation

**Prerequisite**: get access token and access credential settings. Consult the manual **[here](https://github.com/APIHub-CdC/maven-github-packages)**.

**Step 1**: In case the configuration was integrated into the file **settingsAPIHUB.xml** (located in the root of the project), install the dependencies with the following command:

```shell
mvn --settings settingsAPIHUB.xml clean install -Dmaven.test.skip=true
```

**Step 2**: If the configuration was integrated in the  **settings.xml** of the **.m2**, install the dependencies with the following command:

```shell
mvn install -Dmaven.test.skip=true
```

## Getting started

### Step 1. Generate key and certificate
Before launching the test, you must have a keystore for the private key and the certificate associated with it. To generate the keystore, execute the instructions found in ***src/main/security/createKeystore.sh*** or with the following commands:

**Optional**:  If you want to encrypt your container, put a password in an environment variable.

```shell
export KEY_PASSWORD=your_super_secure_password
```

**Optional**: If you want to encrypt your keystore, put a password in an environment variable.

```shell
export KEYSTORE_PASSWORD=your_super_secure_keystore_password
```

- Definition of file names and aliases.

```shell
export PRIVATE_KEY_FILE=pri_key.pem
export CERTIFICATE_FILE=certificate.pem
export SUBJECT=/C=MX/ST=MX/L=MX/O=CDC/CN=CDC
export PKCS12_FILE=keypair.p12
export KEYSTORE_FILE=keystore.jks
export ALIAS=cdc
```
- Generate key and certificate.

```shell
# Generate private key
openssl ecparam -name secp384r1 -genkey -out ${PRIVATE_KEY_FILE}

# Generate public certificate
openssl req -new -x509 -days 365 \
  -key ${PRIVATE_KEY_FILE} \
  -out ${CERTIFICATE_FILE} \
  -subj "${SUBJECT}"

```

- Generate PKCS12 container from private key and certificate

```shell
# Generate PKCS12 container from private key and certificate
# You will need to package your private key and certificate.

openssl pkcs12 -name ${ALIAS} \
  -export -out ${PKCS12_FILE} \
  -inkey ${PRIVATE_KEY_FILE} \
  -in ${CERTIFICATE_FILE} \
  -password pass:${KEY_PASSWORD}

```

- Generate a dummy keystore and delete its content.

```sh
#Generate a Keystore with a pair of dummy keys.
keytool -genkey -alias dummy -keyalg RSA \
    -keysize 2048 -keystore ${KEYSTORE_FILE} \
    -dname "CN=dummy, OU=, O=, L=, S=, C=" \
    -storepass ${KEYSTORE_PASSWORD} -keypass ${KEY_PASSWORD}
#Remove the dummy key pair.
keytool -delete -alias dummy \
    -keystore ${KEYSTORE_FILE} \
    -storepass ${KEYSTORE_PASSWORD}
```

- Import the PKCS12 container to the keystore

```sh
#We import the PKCS12 container
keytool -importkeystore -srckeystore ${PKCS12_FILE} \
  -srcstoretype PKCS12 \
  -srcstorepass ${KEY_PASSWORD} \
  -destkeystore ${KEYSTORE_FILE} \
  -deststoretype JKS -storepass ${KEYSTORE_PASSWORD} \
  -alias ${ALIAS}
#List the contents of the Kesystore to verify that
keytool -list -keystore ${KEYSTORE_FILE} \
  -storepass ${KEYSTORE_PASSWORD}
```

### Step 2. Uploading the certificate within the developer portal

 1. Login
 2. Click on the section "**Mis aplicaciones**".
 3. Select the application.
 4. Go to the tab "**Certificados para @tuApp**"
    <p align="center">
      <img src="https://github.com/APIHub-CdC/imagenes-cdc/blob/master/applications.png">
    </p>
 5. When the window opens, select the previously created certificate and click the button "**Cargar**":
    <p align="center">
      <img src="https://github.com/APIHub-CdC/imagenes-cdc/blob/master/upload_cert.png">
    </p>

### Step 3. Download the Círculo de Crédito certificate within the developer portal
 1. Login.
 2. Click on the section "**Mis aplicaciones**".
 3. Select the application.
 4. Go to the tab "**Certificados para @tuApp**".
    <p align="center">
        <img src="https://github.com/APIHub-CdC/imagenes-cdc/blob/master/applications.png">
    </p>
 5. When the window opens, click the button "**Descargar**":
    <p align="center">
        <img src="https://github.com/APIHub-CdC/imagenes-cdc/blob/master/download_cert.png">
    </p>

### Step 4. Modify configuration file

To make use of the certificate that was downloaded and the keystore that was created, the routes found in **src/main/resources/config.properties**
```properties
keystore_file=your_path_for_your_keystore/keystore.jks
cdc_cert_file=your_path_for_certificate_of_cdc/cdc_cert.pem
keystore_password=your_super_secure_keystore_password
key_alias=cdc
key_password=your_super_secure_password
```

#### Step 5. Get your ```x-api-key```
 Get your ```x-api-key``` Following step 1, 2 and 3 the start guide ***https://developer.circulodecredito.com.mx/guia-de-inicio*** 

#### Step 6. Change url and request data
In the ```Fis2022ApiTest.java``` file, found at ```/src/test/java/com/cdc/apihub/mx/fis2022/client/api/```. The request data for API consumption must be modified as shown in the following code snippet with the corresponding data:


``` java

public class EmploymentVerificationApiTest {
    ...
    private String keystoreFile = "/keystore.jks";//CHANGE IT TO YOUR KEYSTORE PATH
    private String cdcCertFile = "/cdc_cert.pem"; //CHANGE IT TO YOUR CDC CERTIFICATE PATH
    private String keystorePassword = "keystore_password"; //CHANGE IT TO YOUR KEYSTORE PASSWORD
    private String keyAlias = "key_alias"; //CHANGE IT TO YOUR KEY ALIAS
    private String keyPassword = "key_password"; //CHANGE IT TO YOUR KEY PASSWORD

    private String usernameCDC = "username"; //CHANGE IT TO YOUR CDC USERNAME
    private String passwordCDC = "password"; //CHANGE IT TO YOUR CDC PASSWORD

    private String url = "https://circulodecredito-dev.apigee.net/v2/fip";
    private String xApiKey = "your_apikey"; //CHANGE IT TO YOUR API KEY
    ...
    ...
    @Test
    public void devuelveelScoreFISTest() throws Exception {
        ...
        RequestDatosGenerales requestDatosGenerales = new RequestDatosGenerales();

        RequestDatosGenerales requestDatosGenerales = new RequestDatosGenerales();
        requestDatosGenerales.setPrimerNombre("NULL"); //CHANGE TO VALID DATA
        requestDatosGenerales.setApellidoPaterno("NULL"); //CHANGE TO VALID DATA
        requestDatosGenerales.setApellidoMaterno("NULL"); //CHANGE TO VALID DATA
        requestDatosGenerales.setFechaNacimiento("31-12-NULL"); //CHANGE TO VALID DATA
        requestDatosGenerales.setDireccion("INSURGENTES SUR NULL"); //CHANGE TO VALID DATA
        requestDatosGenerales.setColoniaPoblacion("NULL"); //CHANGE TO VALID DATA
        requestDatosGenerales.setCiudad("NULL"); //CHANGE TO VALID DATA
        requestDatosGenerales.setEstado("NULL"); //CHANGE TO VALID DATA
        requestDatosGenerales.setPais("NULL"); //CHANGE TO VALID DATA
        requestDatosGenerales.setDelegacionMunicipio("BENITO NULL"); //CHANGE TO VALID DATA
        requestDatosGenerales.setCp("NULL"); //CHANGE TO VALID DATA
        requestDatosGenerales.setRfc("NULL"); //CHANGE TO VALID DATA
        ...
    }
    ...
}
```
### Step 7. Set request data

This product accepts two types of formats. You can send a request with general information about the person you are interested in or you can configure folios if you prefer.

You must configure the request information (requestDatosGenerales or requestFolios) in the fourth parameter of the "devuelveelScoreFIS" method as shown in the following line of code:

``` java
ResponseScore response = api.devuelveelScoreFIS( xApiKey, usernameCDC, passwordCDC, requestDatosGenerales, contentType);
```

### Step 8. Run the unit test

Having the previous steps, all that remains is to run the unit test, with the following command:
```shell
mvn test -Dmaven.install.skip=true
```

---
[TERMS AND CONDITIONS](https://github.com/APIHub-CdC/licencias-cdc)