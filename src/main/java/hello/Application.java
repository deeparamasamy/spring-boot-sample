package hello;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableAutoConfiguration
@Configuration
@ComponentScan
@EnableJpaRepositories
public class Application {

	/**
	 *	WEB アプリの実行クラス（Tomcat 込み）
	 *	プロジェクトをパッケージするとこのクラスが実行される war が作られる。
	 *	開発時も、純粋にこのクラスを実行してデバッグすればよい。
	 */
	public static void main(String[] args) {
		//	実際はこれだけでいい
//		SpringApplication.run(Application.class);

		//	WEB アプリを走らせつついろいろやってみる
		ApplicationContext	ctx = SpringApplication.run(Application.class, args);

		System.out.println("Let's inspect the beans provided by Spring Boot:");

		String[]				beanNames = ctx.getBeanDefinitionNames();

		Arrays.sort(beanNames);
		for (String beanName : beanNames) {
			System.out.println(beanName);
		}
	}

}