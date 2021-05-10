# NoteApi

All URIs are relative to *http://localhost:8080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addNote**](NoteApi.md#addNote) | **POST** /note | 
[**deleteNote**](NoteApi.md#deleteNote) | **DELETE** /note/{id} | 
[**getNote**](NoteApi.md#getNote) | **GET** /note/{id} | 
[**getVersion**](NoteApi.md#getVersion) | **GET** /version | 


<a name="addNote"></a>
# **addNote**
> Note addNote(note)



Adds a new Note.

### Example
```java
// Import classes:
import com.example.backend.client.invoker.ApiClient;
import com.example.backend.client.invoker.ApiException;
import com.example.backend.client.invoker.Configuration;
import com.example.backend.client.invoker.models.*;
import com.example.backend.client.NoteApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    NoteApi apiInstance = new NoteApi(defaultClient);
    Note note = new Note(); // Note | The note to be created.
    try {
      Note result = apiInstance.addNote(note);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling NoteApi#addNote");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **note** | [**Note**](Note.md)| The note to be created. |

### Return type

[**Note**](Note.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |

<a name="deleteNote"></a>
# **deleteNote**
> deleteNote(id)



Deletes a note by id.

### Example
```java
// Import classes:
import com.example.backend.client.invoker.ApiClient;
import com.example.backend.client.invoker.ApiException;
import com.example.backend.client.invoker.Configuration;
import com.example.backend.client.invoker.models.*;
import com.example.backend.client.NoteApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    NoteApi apiInstance = new NoteApi(defaultClient);
    String id = "id_example"; // String | The UUID of the note to delete.
    try {
      apiInstance.deleteNote(id);
    } catch (ApiException e) {
      System.err.println("Exception when calling NoteApi#deleteNote");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The UUID of the note to delete. |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |

<a name="getNote"></a>
# **getNote**
> Note getNote(id)



Retrives a note by id.

### Example
```java
// Import classes:
import com.example.backend.client.invoker.ApiClient;
import com.example.backend.client.invoker.ApiException;
import com.example.backend.client.invoker.Configuration;
import com.example.backend.client.invoker.models.*;
import com.example.backend.client.NoteApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    NoteApi apiInstance = new NoteApi(defaultClient);
    String id = "id_example"; // String | The UUID of the note to retrieve.
    try {
      Note result = apiInstance.getNote(id);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling NoteApi#getNote");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The UUID of the note to retrieve. |

### Return type

[**Note**](Note.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |

<a name="getVersion"></a>
# **getVersion**
> String getVersion()



Returns the current API version

### Example
```java
// Import classes:
import com.example.backend.client.invoker.ApiClient;
import com.example.backend.client.invoker.ApiException;
import com.example.backend.client.invoker.Configuration;
import com.example.backend.client.invoker.models.*;
import com.example.backend.client.NoteApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    NoteApi apiInstance = new NoteApi(defaultClient);
    try {
      String result = apiInstance.getVersion();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling NoteApi#getVersion");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |

