package br.com.guilhermesilva.desafiotodolist;

import br.com.guilhermesilva.desafiotodolist.entity.Todo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DesafioTodolistApplicationTests {
	@Autowired
	private WebTestClient webTestClient;

	@Test
	void testCreateTodoSuccess() {
		var todo  = new Todo("todo1", "dest todo1", false,1);

		webTestClient
				.post()
				.uri("/todos/create")
				.bodyValue(todo)
				.exchange()
				.expectStatus().isOk()
				.expectBodyList(Todo.class)
				.contains(todo);
//				.jsonPath("$").isArray()
//				.jsonPath("$.length").isEqualTo(1)
//				.jsonPath("$[0].nome").isEqualTo(todo.getNome())
//				.jsonPath("$[0].descricao").isEqualTo(todo.getDescricao())
//				.jsonPath("$[0].realizado").isEqualTo(todo.isRealizado())
//				.jsonPath("$[0].prioridade").isEqualTo(todo.getPrioridade());
	}
	@Test
	void testCreateTodoFailure() {
		webTestClient
				.post()
				.uri("/todos/post")
				.bodyValue(
						new Todo("","",false, 0)
				).exchange()
				.expectStatus().isBadRequest();
	}

}
