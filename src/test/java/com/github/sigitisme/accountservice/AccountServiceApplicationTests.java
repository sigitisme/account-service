package com.github.sigitisme.accountservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.github.sigitisme.accountservice.data.model.Account;
import com.github.sigitisme.accountservice.data.services.AccountService;
import com.github.sigitisme.accountservice.dto.TransferReqBody;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = AccountServiceApplication.class)
@AutoConfigureMockMvc
public class AccountServiceApplicationTests {

	private static final Logger LOGGER = LoggerFactory.getLogger(AccountServiceApplicationTests.class);

	private static final Account ACC_1 = new Account("0012345678", "Eko", 1000, 1);
	private static final Account ACC_2 = new Account("0012345688", "Akri", 2000, 1);

	private static final double AMOUNT = 500.0;

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private AccountService accountService;

	@Before
	public void setUp(){

		LOGGER.info("Setting up test");
		LOGGER.info("Creating 2 accounts");

		accountService.save(ACC_1);
		accountService.save(ACC_2);
	}

	@Test
	public void contextLoads() throws Exception {

		LOGGER.info("Displaying accounts before transfer");
		LOGGER.info("ACC 1 : balance " + ACC_1.getAcctBalance());
		LOGGER.info("ACC 2 : balance " + ACC_2.getAcctBalance());

		TransferReqBody reqBody = new TransferReqBody();
		reqBody.setSenderAcctNo(ACC_1.getAcctNo());
		reqBody.setReceiverAcctNo(ACC_2.getAcctNo());
		reqBody.setAmount(AMOUNT);

		LOGGER.info("Transfer from ACC1 to ACC 2 with amount " + AMOUNT + ".");

		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
		String requestJson=ow.writeValueAsString(reqBody);

		//transfer
		mockMvc.perform(post("/v1/transfer").contentType(APPLICATION_JSON_UTF8_VALUE )
				.content(requestJson)).andDo(print())
				.andExpect(jsonPath("$.status", containsString("0")))
				.andExpect(jsonPath("$.message", containsString("SUCCESS")))
				.andExpect(status().isOk());

		//view transaction
		mockMvc.perform(get("/v1/transactions")).andDo(print())
				.andExpect(jsonPath("$", hasSize(1)))
				.andExpect(jsonPath("$[0].senderAcctNo", containsString(ACC_1.getAcctNo())))
				.andExpect(jsonPath("$[0].receiverAcctNo", containsString(ACC_2.getAcctNo())))
				.andExpect(jsonPath("$[0].amount", is(AMOUNT)))
				.andExpect(jsonPath("$[0].txStatus", is(1)))
				.andExpect(jsonPath("$[0].txDesc", containsString("SUCCESS")))
				.andExpect(status().isOk());

	}
}
