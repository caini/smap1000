package org.wekit.web.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

	@Autowired
	private TestAction testAction;
	
	@RequestMapping(value="/hello.{extend}",method=RequestMethod.GET)
	public String helloWorld(@PathVariable("extend")String extend,Model model)
	{
		System.out.println(extend);
		testAction.say();
		model.addAttribute("message","hello world");
		return "helloworld";
	}
	@RequestMapping("/h.html")
	@ResponseBody
	public String hello()
	{
	  return "tests";
	}

	public TestAction getTestAction() {
		return testAction;
	}

	public void setTestAction(TestAction testAction) {
		this.testAction = testAction;
	}
	
	
}
