package com.pavelgostudy.startandroid.covisor.api;

import com.pavelgostudy.startandroid.covisor.model.auth.AuthRq;
import com.pavelgostudy.startandroid.covisor.model.auth.AuthRs;
import com.pavelgostudy.startandroid.covisor.model.conts.ContactsUpdateRq;
import com.pavelgostudy.startandroid.covisor.model.conts.ContactsUpdateRs;
import com.pavelgostudy.startandroid.covisor.model.repcontsspis.ContactsListRs;
import com.pavelgostudy.startandroid.covisor.model.repcontssave.ContactsSaveRq;
import com.pavelgostudy.startandroid.covisor.model.spisconts.ContactsGroupedRq;
import com.pavelgostudy.startandroid.covisor.model.spisconts.ContactsGroupedRs;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ApiService {

    @GET("/api/Repconts/{emp_id}")
    Call<ContactsListRs> getContactsList(@Path("emp_id") long emp_id);

    @POST("/api/Repconts")
    Call<ContactsSaveRq> saveContact(@Body ContactsSaveRq contactsSaveRq);

    @POST("/api/Spisconts")
    Call<ContactsGroupedRs> getGroupedContacts(@Body ContactsGroupedRq contactsGroupedRq);

    @PUT("/api/Conts")
    Call<ContactsUpdateRq> updateContact(@Body ContactsUpdateRs contactsUpdateRs);

    @POST("api/Auth/")
    Call<AuthRs> authenticateUser(@Body AuthRq rq);


}
