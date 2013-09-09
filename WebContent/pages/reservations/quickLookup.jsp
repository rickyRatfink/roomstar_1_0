<jsp:include page="../../includes/header.jsp"/>


	<div align="center">
	<div id="boxContent">
		<div id="boxHeader">&nbsp;Quick Lookup</div> 
		<form method="POST" action="">
			<div id="boxField">First Name&nbsp;<input type="text" name="firstname" value="" size="20" maxlength="30" class="textbox"/>&nbsp;&nbsp;</div>
			<div id="boxField">Last Name&nbsp;<input type="text" name="lastname" value="" size="20" maxlength="30" class="textbox"/></div>
			<div id="boxField">Confirmation&nbsp;<input type="text" name="lastname" value="" size="50" maxlength="30" class="textbox"/></div>
			<div id="boxField">Room Type&nbsp;
				<select name="lastname" class="select"/>
					<option value=""></option>
					<option value="1">King Bed Non-smoking</option>
					<option value=""></option>
					<option value=""></option>
				</select>
			</div>
			
			
			</br></br></br>
			
			<div id="buttons" align="right">
				<input type="submit" name="action" value="Lookup" class="button"/>
			</div>
			
		</form>
	</div>
	</div>
<jsp:include page="../../includes/footer.jsp"/>
