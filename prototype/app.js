// SpartanVet 
// “login” is a demo with hardcoded accounts.
// store appointments in the browser using localStorage.

// Demo users 
const USERS = {
  customer: { username: "customer", password: "pass" },
  provider: { username: "provider", password: "pass" }
};

// I read appointments from localStorage.
function getAppointments() {
  try {
    return JSON.parse(localStorage.getItem("appointments")) || [];
  } catch {
    return [];
  }
}

// I save appointments back to localStorage.
function setAppointments(appts) {
  localStorage.setItem("appointments", JSON.stringify(appts));
}

// I log out by clearing session info.
function logout() {
  localStorage.removeItem("role");
  localStorage.removeItem("username");
  window.location.href = "login.html";
}

// I protect pages so only the right role can view them.
function requireRole(role) {
  const r = localStorage.getItem("role");
  if (r !== role) window.location.href = "login.html";
}

// Login page logic
(function initLogin() {
  const form = document.getElementById("loginForm");
  if (!form) return;

  form.addEventListener("submit", (e) => {
    e.preventDefault();

    const role = document.getElementById("role").value;
    const u = document.getElementById("username").value.trim();
    const p = document.getElementById("password").value;

    const msg = document.getElementById("msg");
    msg.textContent = "";

    const demo = USERS[role];

    if (u === demo.username && p === demo.password) {
      localStorage.setItem("role", role);
      localStorage.setItem("username", u);

      if (role === "customer") window.location.href = "customer.html";
      else window.location.href = "provider.html";
    } else {
      msg.textContent = "Invalid login. Try customer/pass or provider/pass.";
    }
  });
})();

// Customer: connect form to create appointments
function setupCustomerForm() {
  const form = document.getElementById("apptForm");
  if (!form) return;

  form.addEventListener("submit", (e) => {
    e.preventDefault();

    const petName = document.getElementById("petName").value.trim();
    const date = document.getElementById("date").value;
    const time = document.getElementById("time").value;
    const reason = document.getElementById("reason").value.trim();

    const username = localStorage.getItem("username") || "customer";
    const msg = document.getElementById("custMsg");
    msg.textContent = "";

    if (!petName || !date || !time || !reason) {
      msg.textContent = "Fill out all fields first.";
      return;
    }

    const appts = getAppointments();

    appts.push({
      id: crypto.randomUUID(),
      customer: username,
      petName,
      date,
      time,
      reason,
      status: "Pending"
    });

    setAppointments(appts);
    form.reset();
    renderCustomerAppointments();
  });
}

// Customer: show only my appointments
function renderCustomerAppointments() {
  const container = document.getElementById("myAppts");
  if (!container) return;

  const username = localStorage.getItem("username") || "customer";
  const appts = getAppointments().filter(a => a.customer === username);

  if (appts.length === 0) {
    container.innerHTML = "<p class='hint'>No appointments yet.</p>";
    return;
  }

  container.innerHTML = appts.map(a => `
    <div class="item">
      <div class="row">
        <strong>${a.petName}</strong>
        <span class="badge">${a.status}</span>
      </div>
      <div>${a.date} @ ${a.time}</div>
      <div class="hint">${a.reason}</div>
    </div>
  `).join("");
}

// Provider: show all appointments and allow status updates
function renderProviderAppointments() {
  const container = document.getElementById("allAppts");
  if (!container) return;

  const appts = getAppointments();

  if (appts.length === 0) {
    container.innerHTML = "<p class='hint'>No appointment requests yet.</p>";
    return;
  }

  container.innerHTML = appts.map(a => `
    <div class="item">
      <div class="row">
        <strong>${a.customer}</strong>
        <span class="badge">${a.status}</span>
      </div>
      <div><strong>Pet:</strong> ${a.petName}</div>
      <div><strong>When:</strong> ${a.date} @ ${a.time}</div>
      <div class="hint">${a.reason}</div>

      <div class="row" style="margin-top:8px;">
        <button class="btn" onclick="setStatus('${a.id}','Accepted')">Accept</button>
        <button class="btn" onclick="setStatus('${a.id}','Denied')">Deny</button>
      </div>
    </div>
  `).join("");
}

// Provider: update status (accept/deny)
function setStatus(id, status) {
  const appts = getAppointments();
  const idx = appts.findIndex(a => a.id === id);

  if (idx !== -1) {
    appts[idx].status = status;
    setAppointments(appts);
    renderProviderAppointments();
  }
}

// Provider: clear everything (just for demo/testing)
function clearAppointments() {
  setAppointments([]);
  renderProviderAppointments();
}
