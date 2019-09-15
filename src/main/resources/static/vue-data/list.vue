<template>
	<div class="container">
		<div class="row">
			<div class="col-12">
				<table class="table table-hover">
					<thead>
						<tr>
							<th scope="col">#</th>
							<th scope="col">First name</th>
							<th scope="col">Last name</th>
							<th scope="col">Email</th>
						</tr>
					</thead>
					<tbody>
						<tr v-for="(item, index) in employees">
							<th scope="row">{{index}}</th>
							<td>{{item.firstName}}</td>
							<td>{{item.lastName}}</td>
							<td>{{item.email}}</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<div class="row">
			<div class="col-12">
				<a href="/add_employee" class="btn btn-primary">Add an employee</a>
			</div>
		</div>
	</div>
</template>

<script type="text/javascript">
	var app = new Vue({
		el: '#app',
		data: {
			employees: null
		},
		mounted() {
			axios.get('/api/employee/list').then(response => {
				this.employees = response.data;
			})
		},
	});
</script>